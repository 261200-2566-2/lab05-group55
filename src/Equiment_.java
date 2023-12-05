import java.util.Random;
public interface Equiment_ {
    String getDescribe();
}
interface Armor_ extends Equiment_{
    int defenseIncrease();
}
interface Neckless_ extends Equiment_{
    int attackIncrease();
}
interface MagicArmor_ extends Armor_{
    int perfectGuard();
}
interface HolyArmor_ extends Armor_{
    int healing();
}
interface AncientNeckless_ extends Neckless_{
    int criticalHit();
}
class Equiment implements Equiment_{
    protected String discription;
    Equiment(String discribe){
        this.discription = discribe;
    }

    @Override
    public String getDescribe() {
        return discription;
    }
}
class Armor extends Equiment implements Armor_{
    Armor(String discribe){
        super(discribe);
    }

    @Override
    public int defenseIncrease() {
        return 8;
    }
}
class Neckless extends Equiment implements Neckless_{
    Neckless(String describe){
        super(describe);
    }

    @Override
    public int attackIncrease() {
        return 15;
    }
}
class MagicArmor extends Armor implements MagicArmor_{
    MagicArmor(String discribe){
        super(discribe);
    }

    @Override
    public int perfectGuard() {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        if(randomBoolean){
            return 8888;
        }
        else return 8;
    }
}
class HolyArmor extends Armor implements HolyArmor_{
    HolyArmor(String discribe){
        super(discribe);
    }

    @Override
    public int healing() {
        return 30;
    }
}
class AncientNeckless extends Neckless implements AncientNeckless_{
    AncientNeckless(String describe) {
        super(describe);
    }

    @Override
    public int criticalHit() {
        Random random = new Random();
        int critical = random.nextInt(1, 3);
        return critical;
    }

    @Override
    public int attackIncrease() {
        return 15*criticalHit();
    }
}
