public interface Hero {
    public void lvUp();
    public void attackTarget(Character a);
    public void getJobClass(String job);
    public void equip(Equiment a);
}
    interface Magee extends Hero{
        void fireball(Character a);
    }
    interface Knightt extends Hero{
        public void swordDance();
    }
    interface Summonerr extends Magee{
        public void summonDemons();
    }
    interface ArchSwordmagee extends Magee, Knightt{
        void flameSword(Character target);
    }
    interface Warriorr extends Knightt{
        void quickSlash(Character target);
    }

    class Character implements Hero{
        protected String name;
        protected String job;
        protected int lv = 1;
        protected int atk, hp, def;

        Character(String name){
            this.name = name;
        }
        @Override
        public void lvUp() {
            lv++;
            atk+= 5;
            def+= 3;
        }

        @Override
        public void attackTarget(Character target) {
            target.hp = this.atk - target.def;
        }

        @Override
        public void getJobClass(String job) {
            this.job = job;
        }

        @Override
        public void equip(Equiment item) {
            if(item instanceof Armor){
                def+= ((Armor) item).defenseIncrease();
            }
            else if(item instanceof Neckless){
                atk+= ((Neckless) item).attackIncrease();
            }
        }
    }
    class Mage extends Character implements Magee{
        Mage(String name) {
            super(name);
        }

        @Override
        public void fireball(Character target) {
            target.hp = this.atk*2 - target.def;
        }
    }
    class Knight extends Character implements Knightt{
        Knight(String name){
            super(name);
        }

        @Override
        public void swordDance() {
            atk*=2;
        }
    }
    class Summoner extends Mage implements Summonerr{
        Summoner(String name){
            super(name);
        }

        class Demon{
            int atk;
            int summonerLV;
            public void getLevelOfSummoner(Summoner a){
                summonerLV = a.lv;
            }
            Demon(){
                atk = 5*summonerLV;
            }
        }

        @Override
        public void summonDemons() {
            Demon newbieDemon = new Demon();
        }
    }
    class ArchSwordMage extends Mage implements ArchSwordmagee{
        ArchSwordMage(String name){
            super(name);
        }

        @Override
        public void flameSword(Character target) {
            target.hp = this.atk*2 - target.def;
        }

        @Override
        public void swordDance() {
            atk*= 2;
        }
    }
    class Warrior extends Knight implements Warriorr{
        Warrior(String name){
            super(name);
        }

        @Override
        public void quickSlash(Character target) {
            target.hp = this.atk*2 - target.def;
        }
    }