package org.richit.materialofficeaboutlib.Others;

import org.richit.materialofficeaboutlib.Models.OfficeInfo;

public interface MembersListener {
    void onJsonDataReceived(OfficeInfo officeInfo);

    void onError(String error);
}
