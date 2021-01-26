package dao;

import sun.security.krb5.Config;

public class DaoFactory {
    private static Ads adsDao;
    private static Contacts contactsDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Contacts getContactsDao() {
        if (contactsDao == null){
            contactsDao = new MySQLContactsDao(config);
        }
        return contactsDao;
    }
}
