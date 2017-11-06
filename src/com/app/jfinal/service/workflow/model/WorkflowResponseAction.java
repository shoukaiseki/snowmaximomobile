package com.app.jfinal.service.workflow.model;

public class WorkflowResponseAction {
	
		//操作id
		int actionid; 
		//操作名称
		String instruction;
		int ispositive;
		
		public int getActionid() {
			return actionid;
		}
		public void setActionid(int actionid) {
			this.actionid = actionid;
		}
		public String getInstruction() {
			return instruction;
		}
		public void setInstruction(String instruction) {
			this.instruction = instruction;
		}
		public int getIspositive() {
			return ispositive;
		}
		public void setIspositive(int ispositive) {
			this.ispositive = ispositive;
		}
		

}
