/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *  Clase encargada de detectar cualquier tipo de colisión con obtetos de Límites
 * 
 */
public class DetectorDeColisiones {
    
    /** Detecta colisiones de extremos básicos por la Izquierda
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param world Es la referencia al mundo (Puede no ser necesaria)
    */
    public void BorderCollisionsLeft(Player player, CollisionsWorld colisiones, World world){
        

        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
                     
            if(player.getPlayer().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                && player.getPlayer().getY() <= colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsLeft(i).getHeight()
                    && player.getPlayer().getY()+player.getPlayer().getHeight() >= colisiones.getConjuntoCollisionsLeft(i).getY()){
                
                player.setMover_Left(0);
                colisiones.setSPEED(0);
                world.setSPEED(0);
                break;
            }
            
            else if(player.getPlayer().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                    && player.getPlayer().getY() == colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()){
                
                player.setMover_Left(0);
                colisiones.setSPEED(0);
                world.setSPEED(0);
                break;
            }
            
            else{
                //Si no hay colision continúo con la ejecución normal
                player.setMover_Left(10);
                colisiones.setSPEED(5);
                world.setSPEED(2);
            }        
        }
                       
    }
    
    /** Detecta colisiones de extremos básicos por la Derecha
    * @param player Es la referencia a la nave del jugador
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param world Es la referencia al mundo (Puede no ser necesaria)
    */
    public void BorderCollisionsRight(Player player, CollisionsWorld colisiones, World world){
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsRight().length; i++) {
            
            if(player.getPlayer().getX()+player.getPlayer().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && player.getPlayer().getY() <= colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()
                    && player.getPlayer().getY()+player.getPlayer().getHeight()>= colisiones.getConjuntoCollisionsRight(i).getY()){
                
                player.setMover_Right(0);
                colisiones.setSPEED(0);
                world.setSPEED(0);
                break;
            }
            
            
            else if(player.getPlayer().getX()+player.getPlayer().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && player.getPlayer().getY() == colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()){
                
                player.setMover_Right(0);
                colisiones.setSPEED(0);
                world.setSPEED(0);
                break;
            }
            
             else{
                 //Si no hay colision continúo con la ejecución normal
                player.setMover_Right(10);
                colisiones.setSPEED(5);
                world.setSPEED(2);
            }
 
        }

        
    }
   
    /** Detecta colisiones Con el enemigo
    * @param enemy Es la referencia al enemigo
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param PIXELES Es el tamaño del label del enemigo
    */
    public void BorderCollisionsEnemyRight(Enemy enemy, CollisionsWorld colisiones, int PIXELES){

        for (int i = 0; i < colisiones.getConjuntoCollisionsRight().length; i++) {
            
            if(enemy.getEnemy().getX()+enemy.getEnemy().getWidth() >= colisiones.getConjuntoCollisionsRight(i).getX()
                    && enemy.getEnemy().getY() <= colisiones.getConjuntoCollisionsRight(i).getY()+colisiones.getConjuntoCollisionsRight(i).getHeight()
                    && enemy.getEnemy().getY()+PIXELES >= colisiones.getConjuntoCollisionsRight(i).getY()){
                
                enemy.setVelocidad(enemy.getVelocidad()*(-1));
                enemy.getEnemy().setLocation(enemy.getEnemy().getX()+ enemy.getVelocidad(), enemy.getEnemy().getY()); 
                break;
            } 
        }     
    }
    
    /** Detecta colisiones con el enemigo
    * @param enemy Es la referencia al enemigo
    * @param colisiones Es la referencia a todas las colisiones espaciales
    * @param PIXELES Es el tamaño del label del enemigo
    */
    public void BorderCollisionsEnemyLeft(Enemy enemy, CollisionsWorld colisiones, int PIXELES){
        
        for (int i = 0; i < colisiones.getConjuntoCollisionsLeft().length; i++) {
                     
            if(enemy.getEnemy().getX() <= colisiones.getConjuntoCollisionsLeft(i).getX()+colisiones.getConjuntoCollisionsLeft(i).getWidth()
                && enemy.getEnemy().getY() <= colisiones.getConjuntoCollisionsLeft(i).getY()+colisiones.getConjuntoCollisionsLeft(i).getHeight()
                    && enemy.getEnemy().getY()+PIXELES >= colisiones.getConjuntoCollisionsLeft(i).getY()){
                
                enemy.setVelocidad(enemy.getVelocidad()*(-1));
               enemy.getEnemy().setLocation(enemy.getEnemy().getX()+ enemy.getVelocidad(), enemy.getEnemy().getY()); 
                break;
            }               
        }               
    }
    
    
}

