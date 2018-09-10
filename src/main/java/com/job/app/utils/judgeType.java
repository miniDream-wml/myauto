package com.job.app.utils;

public class judgeType {
	
	public static String type_judge(Object temp) {
        if (temp instanceof Object) {
            return "是Object类型";
        } else if (temp instanceof Integer) {
            return "是Integer类型";
        } else if (temp instanceof String) {
        	return "是String类型";
        }else {
            return "是其他类型";
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
