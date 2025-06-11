package com.jtmc.apps.reforma.domain;

public class CustomTransferRegistry extends TransferRegistry {
    private String fromAccountName;
    private String toAccountName;
    private String entryPersonName;
    private String acceptedPersonName;

    public String getFromAccountName() {
        return fromAccountName;
    }

    public void setFromAccountName(String fromAccountName) {
        this.fromAccountName = fromAccountName;
    }

    public String getToAccountName() {
        return toAccountName;
    }

    public void setToAccountName(String toAccountName) {
        this.toAccountName = toAccountName;
    }

    public String getEntryPersonName() {
        return entryPersonName;
    }

    public void setEntryPersonName(String entryPersonName) {
        this.entryPersonName = entryPersonName;
    }

    public String getAcceptedPersonName() {
        return acceptedPersonName;
    }

    public void setAcceptedPersonName(String acceptedPersonName) {
        this.acceptedPersonName = acceptedPersonName;
    }
}
