//package com.example;
import java.util.*;

/**
 * Hello world!
 *
 */
public class HappyTeams 
{
    

	// static String[] StudentName = {"1","2","3","4","5","6"};

	// static String[] A = {"2","3","4"};
	// static String[] B = {};
	// static String[] C = {"1","2","4"};
	// static String[] D = {"1","2","3"};
	// static String[] E = {"2","3","6"};
	// static String[] F = {"5","2","1"};

	//happiness is 3,2,1




	//static String[] StudentName = {"1","3","4","2","6","5"};


	// static String[] StudentName = {"1","2","3","4","5","6"};

	// static String[] A = {"2","3","4"};
	// static String[] B = {};
	// static String[] C = {"1","2","4"};
	// static String[] D = {"1","2","3"};
	// static String[] E = {"2","3","6"};
	// static String[] F = {"5","2","1"};


	//DATA TO HELP ASSERT DELETE SELF
	// static String[] A = {"1","3","4"};
	// static String[] B = {"2","2","4"};
	// static String[] C = {"3","2","3"};
	// static String[] D = {"4","2","3"};
	// static String[] E = {"5","5","5"};
	// static String[] F = {"6","2","1"};

	static String[] StudentName = new String[100];
	static String[][] StudentSet = new String[100][20];
	static int Students = 0;



	// static String[][] StudentSet= {A,B,C,D,E,F};

	// static String[][] StudentSet= {A,C,D,B,F,E};


	static int teamsize = 2;
	static int verbosity = 0;
	static int swaptimes = 1000;
	static int swaprounds = 100;
	static int rowback = 3;
	
	public static void GetUserArguments(String[] args){
		System.out.println( "try to get arguments" );
		for (int i=0; i< args.length; i++) {
            System.out.println("i: " + i + " is: " + args[i]);
            if (args[i] == "-t"){
            	teamsize = Integer.parseInt(args[i+1]);
            	System.out.println( "get teamsize" );
            }
            if (args[i] == "-v"){
            	verbosity = Integer.parseInt(args[i+1]);
            	System.out.println( "get verbosity" );
            }
            if (args[i] == "-n"){
            	swaptimes = Integer.parseInt(args[i+1]);
            	System.out.println( "get swaptimes" );
            }
            if (args[i] == "-l"){
            	swaprounds = Integer.parseInt(args[i+1]);
            	System.out.println( "get swaprounds" );
            }
            if (args[i] == "-r"){
            	rowback = Integer.parseInt(args[i+1]);
            	System.out.println( "get rowback" );
            }
        }

        System.out.println( "teamsize is : " + teamsize);
        System.out.println( "verbosity is : " + verbosity);
        System.out.println( "swaptimes is : " + swaptimes);
        System.out.println( "swaprounds is : " + swaprounds);
        System.out.println( "rowback is : " + rowback);
	}

	public static void ReadInput(){
		String tokens[];
        Scanner scanner = new Scanner(System.in); 
        while ( scanner.hasNext() ) {
            String aLine = scanner.nextLine();
            tokens = aLine.split(",");

            // do something with the tokens

            // TODO: insert the people into arrays;
            //System.out.println(tokens[0] + "'s preference are: ");
            StudentName[Students] = tokens[0];
            for (int i=1; i<tokens.length; i++){
            	//System.out.println(tokens[i]);
            	StudentSet[Students][i-1] = tokens[i];
            }

            System.out.println("Student's name is: " + StudentName[Students]);

            System.out.println("His choices are: ");
            for (int i = 0; i<StudentSet[Students].length; i++)
            {
            	if (StudentSet[Students][i] != null){
            		System.out.println(StudentSet[Students][i]);
            	}
            }

           	Students++;

        }
        scanner.close(); 
	}

	public static void main( String[] args ){
	    	System.out.println( "we are in" );
	    	//GetUserArguments(args);
	    	//SwapController(3,2,3,3);
	    	ReadInput();
	}


	public void RemoveDuplicate(String[] array, int choices){
		for (int i = 0; i<choices-1; i++){
			for (int j = i+1; j<choices; j++){
				if (array[i] == array[j] && array[j] != "0"){
					array[j] = "0";
				}
			}
		}
	}

	public void RemoveSelf(String[] array, int choices){
		for (int i = 0; i<6; i++){
	    	for (int j = 0; j<3; j++){
	    		if (StudentSet[i][j] == StudentName[i]){
	    			StudentSet[i][j] ="0";
	    		}
	    	}
	    }
	}

	// calculate the Group number
	public static int ReturnGroupNumber(int index, int teamsize){ 
		return index / teamsize +1;
	}

	public static int AmountofGroups(int teamsize){
		return StudentName.length/teamsize;
	}

	public static String[] ReturnGroupMember(int index, int teamsize){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		String[] GourupMember = new String[10];

		int startpoint = (GroupNum -1) * teamsize;  //first position of groupmember
		int endpoint = GroupNum * teamsize -1;		//last 

		for (int i = 0; i < teamsize; i++){
			GourupMember[i] = StudentName[i+startpoint];
		}
		return GourupMember;
	}

	public static int PersonalHappiness(int index, int teamsize, int choices){
		String[] GourupMember = ReturnGroupMember(index,teamsize);
		int happiness = 0;
		int ifhavezero = 0;
		if (StudentSet[index].length == 0){
			return teamsize -1;
		}
		for (int i = 0; i < choices; i++)
		{
			for (int j = 0; j < teamsize; j++){
					if (StudentSet[index][i] == GourupMember[j]){
						happiness += choices-i;
					}
				}
			if (StudentSet[index][i] == "0"){
					ifhavezero = 1;
				}
		}
		return happiness;
		// TODO consider person have no choices and different choices
	}


	public static int TeamHappiness(int index, int teamsize, int choices){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		int startpoint = (GroupNum -1) * teamsize;
		int happiness = 0;
		for (int i = startpoint; i<startpoint+teamsize; i++){
			happiness += PersonalHappiness(i,teamsize,choices);
		}
		return happiness;
	}



	public static int OverallHappiness(int teamsize, int choices){
		int happiness = 0;
		for (int i=1; i<=AmountofGroups(teamsize); i++){
			int startpoint = (i -1) * teamsize;
			happiness += TeamHappiness(startpoint,teamsize,choices);
		}
		return happiness;
	}

	public static double Variance(int teamsize,int choices){
		double variance = 0;
		int Amount = AmountofGroups(teamsize);
		double mean = OverallHappiness(teamsize,choices) / Amount;
		for (int i=1; i<=AmountofGroups(teamsize); i++){
			int startpoint = (i -1) * teamsize;
			// Sum the square of difference between mean and group happiness
			variance += (TeamHappiness(startpoint,teamsize,choices) - mean) * (TeamHappiness(startpoint,teamsize,choices) - mean);
		}
		return variance / Amount;
	}

	public static double getRandom(double min, double max){
	    double x = (int)(Math.random()*((max-min)+1))+min;
	    return x;
	}




	// swap controller to generate the random num; times of swaping; comparing the result
	public static void SwapController(int Times, int teamsize, int choices, int percentage){
		for(int i=0; i<Times; i++){
			int position1 = (int)getRandom(0,5);
			int position2 = (int)getRandom(0,5);
			int BackwardPercentage = (int)getRandom(0,100);
			if (BackwardPercentage <= percentage){
				System.out.println( "Hit backwardButton" );
				return;
			}

			while (position1 == position2){
				position2 = (int)getRandom(0,5);
			}

			String Nameholder = StudentName[position2];
			//make placeholder point to Position2
			String[] Choiceholder = StudentSet[position2];
			//pass values to positionholder to decide if keep track on the happiness
	    	String[] position1holder = new String[10];
	    	String[] position2holder = new String[10];
	    	String position1nameholder = StudentName[position1];
	    	String position2nameholder = StudentName[position2];
	    	System.out.println( "position1 is" + Integer.toString(position1) );
	    	System.out.println( "position2 is" + Integer.toString(position2) );

	    	for (int j=0; j<choices; j++){	
	    		for (int k=0; k<StudentSet[position1].length; k++){
	    			position1holder[j] = StudentSet[position1][j];
	    		}
	    		for (int k=0; k<StudentSet[position2].length; k++){
	    			position2holder[j] = StudentSet[position2][j];
	    		}
	    	}

	    	System.out.println( "position1holder is " + position1 );
	    	for (int a=0;a<3;a++){
	    		System.out.println( position1holder[a] );
	    	}
	    	
			System.out.println( "position2holder is " + position2);
	    	for (int a=0;a<3;a++){
	    		System.out.println( position2holder[a] );
	    	}

	    	//temporary happiness and V
	    	int temphappiness = OverallHappiness(teamsize,choices);
	    	double tempvariance = Variance(teamsize,choices);
	    	System.out.println( "temp OverallHappiness is" + Integer.toString(temphappiness) );
	    	System.out.println( "temp Variance is" + Double.toString(tempvariance) );

	    	Swap(position1,position2);

	    	//happiness  and V after swap
	    	int swaphappiness = OverallHappiness(2,3);
	    	double swapvariance = Variance(2,3);

	    	System.out.println( "swap OverallHappiness is" + Integer.toString(swaphappiness) );
	    	System.out.println( "swap Variance is" + Double.toString(swapvariance) );


	    	for (int a=0; a<StudentName.length; a++){
	    		System.out.println( "Student: " + StudentName[a] );
	    		if (StudentSet[a].length !=0){	    			
		    		for (int b=0; b<choices; b++){
		    			if (StudentSet[a][b] != null){
		    				System.out.println( StudentSet[a][b] );
		    			}
		    		}
	    		}
	    		else{
	    			System.out.println( "this set is NULL" );
	    		}
	    		System.out.println( "Next student" );
	    	}


	    	// keep if Overall is higher
	    	if (swaphappiness >= temphappiness){
	    		System.out.println( "Keep Result" );
	    	}
	    	else{
	    		System.out.println( "Keep Previous Result" );
	    		StudentName[position1] = position1nameholder;
	    		StudentName[position2] = position2nameholder;
	    		StudentSet[position1] = position1holder;
	    		StudentSet[position2] = position2holder;
	    	}


	    	for (int a=0; a<StudentName.length; a++){
	    		System.out.println( "Student: " + StudentName[a] );
	    		if (StudentSet[a].length !=0){	    			
		    		for (int b=0; b<choices; b++){
		    			if (StudentSet[a][b] != null){
		    				System.out.println( StudentSet[a][b] );
		    			}
		    		}
	    		}
	    		else{
	    			System.out.println( "this set is NULL" );
	    		}
	    		System.out.println( "Next student" );
	    	}

		}
	}

	//Swaping function to be called
	public static void Swap(int position1,int position2){

			String Nameholder = StudentName[position2];
			//make placeholder point to Position2
			String[] Choiceholder = StudentSet[position2];

	    	//Swap
	    	StudentSet[position2] = StudentSet[position1];
	    	StudentSet[position1] = Choiceholder;

	    	StudentName[position2] = StudentName[position1];
	    	StudentName[position1] = Nameholder;

		return;
	}







}