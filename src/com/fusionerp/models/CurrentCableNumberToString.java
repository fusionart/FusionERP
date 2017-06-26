package com.fusionerp.models;

public class CurrentCableNumberToString {
	private static String cableNumber = null;
	
	public void numberToString(CableModel cableModel) {
		cableNumber = cableModel.getOperation()+cableModel.getProject()+cableModel.getGroup()+cableModel.getNumber();
		
		
	}

	public static String getCableNumber() {
		return cableNumber;
	}


}
