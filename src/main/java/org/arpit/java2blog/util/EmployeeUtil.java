package org.arpit.java2blog.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.arpit.java2blog.bean.BankAccount;
import org.arpit.java2blog.bean.Department;
import org.arpit.java2blog.entity.BankAccountEntity;
import org.arpit.java2blog.entity.DepartmentEntity;

public class EmployeeUtil {

	public static Map<Integer,BankAccountEntity> bankEnititySetToMap(Set<BankAccountEntity> bankSet){
		Map<Integer,BankAccountEntity> bankMap = new HashMap<Integer, BankAccountEntity>();
		for(BankAccountEntity bankEntity : bankSet) {
			bankMap.put(bankEntity.getId(), bankEntity);
		}
		return bankMap;
	}
	
	public static Map<Integer,BankAccount> bankAccountSetToMap(Set<BankAccount> bankSet){
		Map<Integer,BankAccount> bankMap = new HashMap<Integer, BankAccount>();
		for(BankAccount bank : bankSet) {
			bankMap.put(bank.getId(), bank);
		}
		return bankMap;
	}
	
	public static Map<Integer,DepartmentEntity> deptEntitySetToMap(Set<DepartmentEntity> deptSet){
		Map<Integer,DepartmentEntity> deptMap= new HashMap<Integer, DepartmentEntity>();
		for(DepartmentEntity dept : deptSet) {
			deptMap.put(dept.getId(), dept);
		}
		return deptMap;
	}
	
	public static Map<Integer,Department> departmentSetToMap(Set<Department> deptSet){
		Map<Integer,Department> deptMap= new HashMap<Integer, Department>();
		for(Department dept : deptSet) {
			deptMap.put(dept.getId(), dept);
		}
		return deptMap;
	}
}
