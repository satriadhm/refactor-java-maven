package lib;

import java.util.List;

public class AdditionalInformation {
    private boolean isForeigner;

	private String spouseName;
	private String spouseIdNumber;
    private List<String> childNames;
	private List<String> childIdNumbers;

    public AdditionalInformation(boolean isForeigner, String spouseName, String spouseIdNumber, List<String> childNames, List<String> childIdNumbers) {
        this.isForeigner = isForeigner;
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
        this.childNames = childNames;
        this.childIdNumbers = childIdNumbers;
    }

    public boolean getIsForeigner() {
        return this.isForeigner;
    }

    public String getSpouseName() {
        return this.spouseName;
    }

    public String getSpouseIdNumber() {
        return this.spouseIdNumber;
    }

    public List<String> getChildNames() {
        return this.childNames;
    }

    public List<String> getChildIdNumbers() {
        return this.childIdNumbers;
    }

    public void setIsForeigner(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }
    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}
}
