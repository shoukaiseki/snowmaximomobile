package org.shoukaiseki.jfinal.kernel.login

import com.jfinal.kit.PropKit
import org.apache.log4j.Logger
import java.security.MessageDigest
import java.util.*
import javax.naming.Context
import javax.naming.NamingException
import javax.naming.directory.SearchControls
import javax.naming.ldap.InitialLdapContext
import javax.naming.ldap.LdapContext

/**
 * com.app.jfinal.service.login.LdapUtilVerification <br></br>

 * @author 蒋カイセキ    Japan-Tokyo  2017-06-15 15:02:56<br></br>
 * *         ブログ http://shoukaiseki.blog.163.com/<br></br>
 * *         E-メール jiang28555@Gmail.com<br></br>
 */

object LdapUtilVerification {

    private val log = Logger.getLogger("wmc.sso.ldap")
    private var principal: String? = null
    private var adminPassword: String? = null
    private var ldap_url: String? = null
    private var searchName: String? = null
    private var searchFilter: String? = null


    /***
     * MD5加码 生成32位md5码
     */
    fun encodeMD5(inStr: String): String {
        var md5: MessageDigest? = null
        try {
            md5 = MessageDigest.getInstance("MD5")
        } catch (e: Exception) {
            println(e.toString())
            e.printStackTrace()
            return ""
        }

        val charArray = inStr.toCharArray()
        val byteArray = ByteArray(charArray.size)

        for (i in charArray.indices)
            byteArray[i] = charArray[i].toByte()
        val md5Bytes = md5!!.digest(byteArray)
        val hexValue = StringBuffer()
        for (i in md5Bytes.indices) {
            val `val` = md5Bytes[i].toInt() and 0xff
            if (`val` < 16)
                hexValue.append("0")
            hexValue.append(Integer.toHexString(`val`))
        }
        return hexValue.toString()

    }

    fun verification(user: String, password: String): String {
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
                    pas = encodeMD5(pas)
                    log.debug("md5.password=" + pas)
                    log.debug("para.password=" + password)
                    if (password.equals(pas, ignoreCase = true)) {
                        returnStr = "SUCCESS"
                    } else {
                        returnStr = "输入密码错误"
                    }
                    ctx.close()
                    return returnStr

                } else {
                    returnStr = "LDAP中密码为空,需要到'盾安导航'修改密码"
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
