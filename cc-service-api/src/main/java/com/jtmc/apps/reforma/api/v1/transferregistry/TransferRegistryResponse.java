package com.jtmc.apps.reforma.api.v1.transferregistry;

import java.time.Instant;
import java.util.UUID;

public class TransferRegistryResponse {
    public UUID transferRegistryId;
    public int fromAccountId;
    public String fromAccountName;
    public int toAccountId;
    public String toAccountName;
    public int fromAccountCatalogCountId;
    public int toAccountCatalogCountId;
    public String entryPersona;
    public Instant entryDate;
    public String entryDateText;
    public double amount;
    public String acceptedPersona;
    public Instant acceptedDate;
    public String acceptedDateText;
}
