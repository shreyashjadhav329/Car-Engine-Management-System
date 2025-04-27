package edu.jsp.carengine.controller;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.carengine.model.Car;
import edu.jsp.carengine.model.Engine;

public class DriverClass {
	
	
static 	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
static 	EntityManager em = entityManagerFactory.createEntityManager();
static 	EntityTransaction entityTransaction = em.getTransaction();
	

//	Engine engine =new Engine();
//	engine.setId(1);
//	engine.setCc(1000);
//	engine.setType("petrol");
//		
//	Car car1 =new Car();
//		car1.setId(1);
//car1.setName("vivek");
//		car1.setEngine(engine);
//	
//	entityTransaction.begin();
//		em.persist(engine);
//	em.persist(car1);
//	entityTransaction.commit();

//		Engine engine2 =em.find(Engine.class, 2);
//		Class<? extends Engine> cc = engine2.getClass();
//		int id = engine2.getId();
//	String type = engine2.getType();	
//
//	Car car =em.find(Car.class, 1);
//	int id2 = car.getId();
//	String name = car.getName();
//	Engine engine = car.getEngine();
//	Class<? extends Engine> cc2 = engine2.getClass();
//	int id3 = engine2.getId();
//	String type2 = engine2.getType();
		// System.out.println(type2);

//	Car car2 =em.find(Car.class, 1);
//	System.out.println(car2);

//		Car car = em.find(Car.class, 1);
//		Engine engineToRemove = car.getEngine();
//		car.setEngine(null);
//		entityTransaction.begin();
//		em.merge(car);
//		em.remove(engineToRemove);
//		entityTransaction.commit();

//		Engine engine =new Engine();
//		engine.setId(2);
//		engine.setCc(2000);
//		engine.setType("petrol");
//			
//		Car car1 =new Car();
//		car1.setId(3);
//	car1.setName("Tata");
//			car1.setEngine(engine);
//		
//		entityTransaction.begin();
//			em.persist(engine);
//		em.persist(car1);
//		entityTransaction.commit();	

	
	public  static void storetheCarwithEngine(int eid,float ecc,String etype,int cid ,String  cname)
	{
		try {
			Engine engine = new Engine();
			engine.setId(eid);
			engine.setCc(ecc);
			engine.setType(etype);
			Car car = new Car();
			car.setId(cid);
			car.setName(cname);
			car.setEngine(engine);
			System.out.println("U sucessfully add car and engine");
			
		entityTransaction.begin();
		em.persist(engine);
		em.persist(car);
		entityTransaction.commit();
	}catch( javax.persistence.RollbackException e) {
		System.out.println("dont use same id again");
	}
	}
	public static void storeCarOnly(int cid, String cname) {
		try {
			Car car = new Car();
			car.setId(cid);
			car.setName(cname);
			
			entityTransaction.begin();
			em.persist(car);
			entityTransaction.commit();	
		}catch(javax.persistence.RollbackException e) {
		}
	}
	public static void storeEngineOnly(int eid, float ecc,String etype) {
		try {
			Engine engine = new Engine();
			engine.setId(eid);
			engine.setCc(ecc);
			engine.setType(etype);
		
			entityTransaction.begin();
			em.persist(engine);
			entityTransaction.commit();
		}
		catch(javax.persistence.RollbackException e) {
			System.out.println("Enter the engine newid which is not already store");
		}
	}
	public static void readCarEngine(int cid) {
		try {
			Car car = em.find(Car.class,cid );
			System.out.println(" Car no : "+car.getId());
			System.out.println("Car name : "+car.getName());
			System.out.println("Cars engine number : "+car.getEngine());
			System.out.println("Engine info");
			System.out.println("Engine id : "+car.getEngine().getId());
			System.out.println("Engine cc : "+car.getEngine().getCc());
			System.out.println("Engine type :"+car.getEngine().getType());
			}catch(Exception e) {
			
		}
		
		
	}
	public static void readCarOnly(int cid) {
		try {
			Car car = em.find(Car.class,cid );
			System.out.println(" Car no : "+car.getId());
			System.out.println("Car name : "+car.getName());
			System.out.println("Cars engine number : "+car.getEngine());
		}catch(Exception e) {
			
		}
	}
	public static void readEngineOnly(int eid) {
		try {
			Engine engine2=em.find(Engine.class, eid);
			System.out.println("Engine id : "+engine2.getId());
			System.out.println("Engine Cc : "+engine2.getCc());
			System.out.println("Engine type : "+engine2.getType());
		}catch(Exception e) {
			
		}
	}
	
	public static void updateCarsEngine(int cid ,int eid,float ecc,String  etype) {
		 try {
		        Car car = em.find(Car.class, cid);
		        if (car != null) {
		        	Engine newengine=new Engine();
		        	newengine.setId(eid);
		        	newengine.setCc(ecc);
		        	newengine.setType(etype);
		        	car.setEngine(newengine);
		            entityTransaction.begin();
		            em.persist(newengine);
		            em.merge(car);
		            entityTransaction.commit();
		        }
		        else {
		            System.out.println("Car not found with id: " + cid);
		        }
		    } catch (Exception e) {
		        System.out.println("Error updating car: " + e.getMessage());
		    }
		  
		        
		
	}


public static void updateCar(int cid, String newName) {
    try {
        Car car = em.find(Car.class, cid);
        if (car != null) {
            car.setName(newName);
            entityTransaction.begin();
            em.merge(car);
            entityTransaction.commit();
            System.out.println("Car updated successfully.");
        } else {
            System.out.println("Car not found with id: " + cid);
        }
    } catch (Exception e) {
        System.out.println("Error updating car: " + e.getMessage());
    }
}

public static void updateEngine(int eid, float newCc, String newType) {
    try {
        Engine engine = em.find(Engine.class, eid);
        if (engine != null) {
            engine.setCc(newCc);
            engine.setType(newType);
            entityTransaction.begin();
            em.merge(engine);
            entityTransaction.commit();
            System.out.println("Engine updated successfully.");
        } else {
            System.out.println("Engine not found with id: " + eid);
        }
    } catch (Exception e) {
        System.out.println("Error updating engine: " + e.getMessage());
    }
}
public static void removeEngineFromCar(int cid) {
    try {
        Car car = em.find(Car.class, cid);
        if (car != null) {
            Engine engineToRemove = car.getEngine();
            if (engineToRemove != null) {
                car.setEngine(null);
                entityTransaction.begin();
                em.merge(car);            // Update the car (engine set to null)
                em.remove(engineToRemove); // Remove the engine separately
                entityTransaction.commit();
                System.out.println("Engine detached and removed successfully.");
            } else {
                System.out.println("This car has no engine assigned.");
            }
        } else {
            System.out.println("Car not found with id: " + cid);
        }
    } catch (Exception e) {
        System.out.println("Error while removing engine: " + e.getMessage());
    }
}
public static void deleteCar(int cid) {
    try {
        Car car = em.find(Car.class, cid);
        if (car != null) {
            entityTransaction.begin();
            em.remove(car);
            entityTransaction.commit();
            System.out.println("Car deleted successfully.");
        } else {
            System.out.println("Car not found with id: " + cid);
        }
    } catch (Exception e) {
        System.out.println("Error deleting car: " + e.getMessage());
    }
}

public static void deleteEngine(int eid) {
    try {
        Engine engine = em.find(Engine.class, eid);
        if (engine != null) {
            entityTransaction.begin();
            em.remove(engine);
            entityTransaction.commit();
            System.out.println("Engine deleted successfully.");
        } else {
            System.out.println("Engine not found with id: " + eid);
        }
    } catch (Exception e) {
        System.out.println("Error deleting engine: " + e.getMessage());
    }
}

}

