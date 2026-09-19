class Lock {
    private final int lockerNumber;
    private String code;

    Lock(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class Locker {
    public static void main(String[] args) {
        Lock l = new Lock(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}