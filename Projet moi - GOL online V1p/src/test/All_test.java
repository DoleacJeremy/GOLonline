package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import math_util.Position_test;

@RunWith(Suite.class)
@SuiteClasses({ AmmasCellulaire_test.class, 
				Cellule_test.class, 
				Position_test.class 
			  })


public class All_test {}