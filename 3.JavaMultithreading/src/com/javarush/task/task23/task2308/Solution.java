package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
<<<<<<< HEAD
=======

    public final static class Constants {
        public final static String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is not currently accessible.";
        public final static String USER_IS_BANNED = "The user is banned.";
        public final static String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public final static String ACCESS_IS_DENIED = "Access is denied.";

    }

>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.ACCESS_IS_DENIED, cause);
        }
    }

    public static void main(String[] args) {

    }
<<<<<<< HEAD

    public final class Constants {
        final static String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is not currently accessible.";
        final static String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        final static String USER_IS_BANNED = "The user is banned.";
        final static String ACCESS_IS_DENIED = "Access is denied.";


    }
=======
>>>>>>> 868a4eae797161c67a4d9d5eb80d92a4e250d3d0
}
