package viceCity.models.guns;

public class Rifle extends BaseGun{
    public Rifle(String name) {
        super(name, 50, 500);
    }
    public int fire() {
        //The pistol shoots only one bullet.
        int newBullets= this.getTotalBullets()-1;
        if(canFire()){
            setTotalBullets( getTotalBullets()-5);
            setBulletsPerBarrel(getBulletsPerBarrel()-5);
            if (getBulletsPerBarrel()==0){
                setTotalBullets(getTotalBullets()-50);
                setBulletsPerBarrel(50);
            }
            return 5;
        }
        return 0;
    }
}
