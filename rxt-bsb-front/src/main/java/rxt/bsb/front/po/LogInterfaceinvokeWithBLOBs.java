package rxt.bsb.front.po;

public class LogInterfaceinvokeWithBLOBs extends LogInterfaceinvoke {
    private String sendPackage;

    private String receivePackage;

    public String getSendPackage() {
        return sendPackage;
    }

    public void setSendPackage(String sendPackage) {
        this.sendPackage = sendPackage == null ? null : sendPackage.trim();
    }

    public String getReceivePackage() {
        return receivePackage;
    }

    public void setReceivePackage(String receivePackage) {
        this.receivePackage = receivePackage == null ? null : receivePackage.trim();
    }
}