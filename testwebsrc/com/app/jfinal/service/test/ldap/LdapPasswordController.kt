package com.app.jfinal.service.test.ldap

import com.jfinal.kit.PropKit
import com.jfinal.plugin.activerecord.Db
import org.shoukaiseki.jfinal.kernel.AbstractController
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.exception.SnowException
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig
import org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat
import org.apache.log4j.Logger
import java.security.MessageDigest
import java.util.*
import javax.naming.Context
import javax.naming.NamingException
import javax.naming.directory.SearchControls
import javax.naming.ldap.InitialLdapContext
import javax.naming.ldap.LdapContext
import kotlin.collections.HashMap


/** com.app.jfinal.service.test.ldap.LdapPasswordController <br>
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-04 14:14:44<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
class LdapPasswordController : AbstractController(){

    companion object {
        @JvmField var TAG:String="testldap"
    }

    fun getldappassword(){
        try{
            initJsonModel()
            val loginid=getCanshu("loginid")
            val data= hashMapOf<String, String>()
            data["ldap"]=getLdapPassword(loginid)
            jsonModel.addDatas(data)

            throw SnowException(1,"$data")

            render(jsonModel)

        }catch (e: SnowException){
            e.printStackTrace()
            renderException(e)
        } catch (e:Exception) {
            e.printStackTrace();
            renderException(SnowException(10000,e))
        }

    }



    private val log = Logger.getLogger("wmc.sso.ldap")
    private var principal: String? = null
    private var adminPassword: String? = null
    private var ldap_url: String? = null
    private var searchName: String? = null
    private var searchFilter: String? = null



    fun getLdapPassword(user: String): String {
        //        String principal = "cn=ldapadmin,cn=users,DC=DunAn,DC=cn";
        //        String LDAP_URL = "ldap://172.16.8.5:389"; //LDAP访问地址
        //        String adminPassword = "admin@password12345"; //密码
        var ctx: LdapContext? = null
        var returnStr = "ERROR"
        try {

            if (principal == null) {
                PropKit.use("snow.properties");
                principal = PropKit.get("sks.ldap.security_principal")
                log.debug("principal=" + principal)
                adminPassword = PropKit.get("sks.ldap.security_credentials")
                log.debug("adminPassword=" + adminPassword)
                ldap_url = PropKit.get("sks.ldap.provider_url")
                log.debug("ldap_url=" + ldap_url)
                searchName = PropKit.get("sks.ldap.search_name")
                searchFilter = PropKit.get("sks.ldap.search_filter")
            }

            val HashEnv = Hashtable<String, String>()
            HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple")
            //AD User
            HashEnv.put(Context.SECURITY_PRINCIPAL, principal!!)
            //AD Password
            HashEnv.put(Context.SECURITY_CREDENTIALS, adminPassword!!)
            //LDAP工厂类
            HashEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory")
            HashEnv.put(Context.PROVIDER_URL, ldap_url!!)
            ctx = InitialLdapContext(HashEnv, null)
            val searchCtls = SearchControls() //Create the search controls
            searchCtls.searchScope = SearchControls.SUBTREE_SCOPE //Specify the search scope

            val answer = ctx.search(searchName, searchFilter!!.replace("\${user}",user), searchCtls)

            if (answer == null) {
                log.debug("answer is null")
                returnStr = "LDAP查询错误"
                ctx.close()
                return returnStr
            }
            if (answer.hasMoreElements()) {
                val obj = answer.next()
                val attr = obj.attributes
                val id = attr.get("sAMAccountName").get().toString()
                log.debug("id=" + id)
                if (attr.get("userPassword") != null) {
                    val pasObj = attr.get("userPassword").get()
                    val s = pasObj as ByteArray
                    var pas = String(s)
                    log.debug("password=" + pas)
                    returnStr = pas
                    ctx.close()
                    return returnStr

                } else {
                    returnStr = "LDAP中无效的密码"
                    ctx.close()
                    return returnStr
                }
            } else {
                returnStr = "LDAP中用户名不存在"
                ctx.close()
                return returnStr
            }
        } catch (e: Exception) {
            e.printStackTrace()
            log.error("", e)
            returnStr = "LDAP验证出现错误:" + e.localizedMessage
        } finally {
            if (ctx != null) {
                try {
                    ctx.close()
                } catch (e: NamingException) {
                    e.printStackTrace()
                    log.error("", e)
                }

            }
        }
        return returnStr

    }

}
