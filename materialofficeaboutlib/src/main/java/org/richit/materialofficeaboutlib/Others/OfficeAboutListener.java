package org.richit.materialofficeaboutlib.Others;

import org.richit.materialofficeaboutlib.Models.OfficeInfo;

public interface OfficeAboutListener {
    void onJsonDataReceived(OfficeInfo officeInfo, String jsonFromOnline);

    void onError(String error);
}
