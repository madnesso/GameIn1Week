package stickmantowerdefence;
//import User.java;
public class Shop
    {

private Handler hand;

//private U

public Shop(Handler h){
    hand=h;

}
        public void upgradeMaxhealth(ID id){

            for (GameObject tempObject : hand.objects)
            {
                if (tempObject.getId().equals(id)){
                    if(id.equals(ID.warrior)) {
                        ((stickmantowerdefence.Warrior) tempObject).setMaxhealth(1000);
                    }

                    if(id.equals(ID.archer)) {
                        ((stickmantowerdefence.Archer) tempObject).setMaxhealth(600);
                    }

                    if(id.equals(ID.mage)) {
                        ((stickmantowerdefence.Mage) tempObject).setMaxhealth(700);
                    }

                    if(id.equals(ID.healer)) {
                        ((stickmantowerdefence.Healer) tempObject).setMaxhealth(800);
                    }

                    if(id.equals(ID.tower)) {
                        ((stickmantowerdefence.Tower) tempObject).setMaxhealth(3000);
                    }


                }
            }

            }


        public void upgradeattack(ID id){

            for (GameObject tempObject : hand.objects)
            {
                if (tempObject.getId().equals(id)){
                    if(id.equals(ID.warrior)) {
                        ((Warrior) tempObject).attackinc= 200;
                    }

                    if(id.equals(ID.archer)) {
                        ((stickmantowerdefence.Archer) tempObject).attackinc= 100;
                    }

                    if(id.equals(ID.mage)) {
                        ((stickmantowerdefence.Mage) tempObject).attackinc= 100;
                    }

                }
            }

        }


    }
