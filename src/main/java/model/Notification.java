package model;

import java.io.Serializable;
import java.util.Date;

public class Notification implements Serializable {
    /*Serializable olmazsa doğru bir şekilde serialize edip kuyruğa göderemeyiz.
    Kuyrukda geri aldığımızda da onu java tarafında anlamlı bir şekilde
    proses edemeyebiliriz,dönüştüremeyebiliriz.
     */
    private String notificationId;
    private Date createdAt;
    private Boolean view;
    private String message;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getView() {
        return view;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {  //NotificationListener'daki ToString onun her seferinde instance by Id sini
        //kullacağı için toString oluşturduk.
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", createdAt=" + createdAt +
                ", view=" + view +
                ", message='" + message + '\'' +
                '}';
    }


}
