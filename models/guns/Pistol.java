package viceCity.models.guns;

public class Pistol extends BaseGun{
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        //The pistol shoots only one bullet.
      int newBullets= this.getTotalBullets()-1;
      if(canFire()){
          setTotalBullets( getTotalBullets()-1);
          setBulletsPerBarrel(getBulletsPerBarrel()-1);
          if (getBulletsPerBarrel()==0){
              setTotalBullets(getTotalBullets()-10);
              setBulletsPerBarrel(10);
          }
          return 1;
      }
        return 0;
    }
}
