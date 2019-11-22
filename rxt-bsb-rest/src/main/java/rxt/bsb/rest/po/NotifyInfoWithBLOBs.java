package rxt.bsb.rest.po;

public class NotifyInfoWithBLOBs extends NotifyInfo {
    private String sendOriginal;

    private String sendCiphertext;

    private String receiveOriginal;

    private String receiveCiphertext;

    public String getSendOriginal() {
        return sendOriginal;
    }

    public void setSendOriginal(String sendOriginal) {
        this.sendOriginal = sendOriginal == null ? null : sendOriginal.trim();
    }

    public String getSendCiphertext() {
        return sendCiphertext;
    }

    public void setSendCiphertext(String sendCiphertext) {
        this.sendCiphertext = sendCiphertext == null ? null : sendCiphertext.trim();
    }

    public String getReceiveOriginal() {
        return receiveOriginal;
    }

    public void setReceiveOriginal(String receiveOriginal) {
        this.receiveOriginal = receiveOriginal == null ? null : receiveOriginal.trim();
    }

    public String getReceiveCiphertext() {
        return receiveCiphertext;
    }

    public void setReceiveCiphertext(String receiveCiphertext) {
        this.receiveCiphertext = receiveCiphertext == null ? null : receiveCiphertext.trim();
    }
}