package org.example;
import java.util.Iterator;
import java.util.logging.Logger;

import static org.example.Application.servicesProviders;

public class Admin {
    private String username;
    private String password;
    private boolean isLogged;
    private static final Logger logger = Logger.getLogger(Admin.class.getName());
    public Admin(){
        username=null;
        password=null;
        isLogged=false;
    }



    public void setUsername(String username){
        this.username=username;
}

    public void setPassword(String password) {
        this.password = password;
    }
    public void setLogged(boolean isLogged){
        this.isLogged=isLogged;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getLogged(){
        return this.isLogged;
    }
    public String addServiceProvider(String username,String password,String phoneNember,String email){


        ServiceProvider s=new ServiceProvider();
        for(ServiceProvider aa:servicesProviders){
            if(aa.getEmail().equals(email)||aa.getUsername().equals(username)) {
                return "Invalid information, The register failed";
            }
        }


        s.setUsername(username);
        s.setPassword(password);
        s.setPhoneNum(phoneNember);
        s.setEmail(email);
        setLogged(false);
        servicesProviders.add(s);
        return "ServiceProvider added successfully";
    }


    public String deleteServiceProvider(String username, String phoneNumber) {
        Iterator<ServiceProvider> iterator = servicesProviders.iterator();
        while (iterator.hasNext()) {
            ServiceProvider s = iterator.next();
            if (s.getPhoneNum().equals(phoneNumber) && s.getUsername().equals(username)) {
                iterator.remove();
                return "The ServiceProvider is removed";
            }
        }
        return null;
    }
    public String printServiceProviders(){
        for(ServiceProvider s : servicesProviders) {
            String message = String.format(
                    "Username: %s     PhoneNumber: %s     Email: %s",
                    s.getUsername(), s.getPhoneNum(), s.getEmail()
            );
            logger.info(message);
        }
        return "All service providers have been printed";
    }

    public String printUsers(){
        for (User u : Application.users) {
            String message = String.format(
                    "Username: %s     PhoneNumber: %s     Email: %s",
                    u.getUsername(), u.getPhoneNum(), u.getEmail()
            );
            logger.info(message);
        }
        return "All users have been printed";
    }

    public String printEvents(){
        for(Event e : Application.events) {
            String message = String.format(
                    "Event Title: %s   Location: %s   Date: %s   Start at: %s   End at: %s   Number of Invitees: %d   User Name: %s   Package Id: %s   Service Provider: %s",
                    e.getEventTitle(), e.getLocation(), e.getDate(), e.getStartAt(), e.getEndAt(), e.getNumOfInvitees(), e.getUserName(), e.getPackegeId(), e.getServiceProviderName()
            );
            logger.info(message);
        }
        return "All events have been printed";
    }
    public String updateServiceProvider(String username, int updateType, String newValue) {
        for (ServiceProvider serviceProvider : servicesProviders) {
            if (serviceProvider.getUsername().equals(username)) {
                if (updateType == 1) {
                    serviceProvider.setPassword(newValue);
                    return "Password updated successfully for " + username;
                } else if (updateType == 2) {
                    serviceProvider.setPhoneNum(newValue);
                    return "Phone number updated successfully for " + username;
                }
            }
        }
        return "Service provider not found";
    }

}
