package xuanc;

/**
 * @author xuanc
 */
public enum Gender {
    /**
     * 性别
     * --------------
     * 此处的枚举值必须调用对应的构造器来创建
     */
    MALE("男"), FEMALE("女");

    private String name;

    private Gender(String name) {
        this.name = name;
    }

    public void setName(String name) {
        final String male = "男", female = "女";

        switch (this) {
            case MALE: {
                if (male.equals(name)) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            }

            case FEMALE: {
                if (female.equals(name)) {
                    this.name = "女";
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            }
            default:
                break;
        }
    }

    public String getName() {
        return name;
    }
}
