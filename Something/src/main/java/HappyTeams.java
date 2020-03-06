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
	static int[] StudentIndex = new int[100];
	static String[][] StudentSet = new String[100][20];
	static int Students = 0;
	static boolean EqualGroups = true;

	static String[] DefaultStudentName = new String[100];
	static int[] DefaultStudentIndex = new int[100];
	static String[][] DefaultStudentSet = new String[100][20];

	static int StorageSize = 0;
	static String[][] StudentNameStorage = new String[100][100];
	static int[][] StudentIndexStorage = new int[100][100];
	static String[][][] StudentSetStorage = new String[100][100][20];
	static double[] VarianceStorage = new double[100];
	static int[] HappinessStorage = new int[100];
	static int HappinessCompare;
	static double VarianceCompare;
	static boolean GoodVchoice = true;




	// static String[][] StudentSet= {A,B,C,D,E,F};

	// static String[][] StudentSet= {A,C,D,B,F,E};

	//default values that can be modify by user
	static int teamsize = 2;
	static int verbosity = 0;
	static int swaptimes = 1000;
	static int swaprounds = 100;
	static int rollback = 3;

	static int choices = 6;
	
	public static void GetUserArguments(String[] args){
		// System.out.println( "try to get arguments" );
		for (int i=0; i< args.length; i++) {
            //System.out.println("i: " + i + " is: " + args[i]);
            if (args[i].equals("-t")){
            	teamsize = Integer.parseInt(args[i+1]);
            	//System.out.println( "get teamsize" );
            }
            if (args[i].equals("-v")){
            	verbosity = Integer.parseInt(args[i+1]);
            	//System.out.println( "get verbosity" );
            }
            if (args[i].equals("-n")){
            	swaptimes = Integer.parseInt(args[i+1]);
            	//System.out.println( "get swaptimes" );
            }
            if (args[i].equals("-l")){
            	swaprounds = Integer.parseInt(args[i+1]);
            	//System.out.println( "get swaprounds" );
            }
            if (args[i].equals("-r")){
            	rollback = Integer.parseInt(args[i+1]);
            	//System.out.println( "get rollback" );
            }
        }

        // System.out.println( "teamsize is : " + teamsize);
        // System.out.println( "verbosity is : " + verbosity);
        // System.out.println( "swaptimes is : " + swaptimes);
        // System.out.println( "swaprounds is : " + swaprounds);
        // System.out.println( "rollback is : " + rollback);
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
            StudentIndex[Students] = Students+1;
            for (int i=1; i<tokens.length; i++){
            	//System.out.println(tokens[i]);
            	StudentSet[Students][i-1] = tokens[i];
            }

            // System.out.println("Student's name is: " + StudentName[Students]);

            // System.out.println("His choices are: ");
            int countHighestpref = 0;
            for (int i = 0; i<StudentSet[Students].length; i++)
            {
            	if (StudentSet[Students][i] != null){
            		// System.out.println(StudentSet[Students][i]);
            		if (countHighestpref < i+1){
            			countHighestpref = i+1;
            		}
            	}
            }
            if (countHighestpref > choices){
            	choices = countHighestpref;
            }
           	Students++;

        }
        scanner.close();
        for (int i=0; i<Students; i++){
        	DefaultStudentName[i] = StudentName[i];
        }

        for (int i=0; i<Students; i++){
        	DefaultStudentIndex[i] = StudentIndex[i];
        }

        for (int i=0; i<Students; i++){
        	for(int j=0; j<choices; j++){
        		DefaultStudentSet[i][j] = StudentSet[i][j];
        	}
        }
	}

	public static void main( String[] args ){
	    	//System.out.println( "we are in" );
	    	//System.out.println( verbosity );
	    	MainController(args);
	    	// GetUserArguments(args);
	    	// ReadInput();
	    	// IfequalGroups();
	  //   	System.out.println( "We have " + choices + " choices" );
	  //   	System.out.println( "amount of groups are: " + AmountofGroups(teamsize));
	  //   	System.out.println(AmountofPersoninGroups(0) + " people in group 1");
	  //   	System.out.println(AmountofPersoninGroups(3) + " people in group 2");
	  //   	String[] GroupMember = ReturnGroupMember(3,teamsize);
	  //   	System.out.println("Number "+ ReturnGroupNumber (3,teamsize) + " Group");
	  //   	for (int i=0; i<teamsize; i++){
	  //   		if (GroupMember[i] != null){
	  //   			System.out.println(GroupMember[i]);
	  //   		}	    		
	  //   	}
	  //   	for(int i=0; i<Students; i++)
	  //   	{
	  //   		System.out.println( StudentName[i] + "'s happiness is: "+ PersonalHappiness(i,teamsize,choices));
	  //   	}

	  //   	for (int i=0; i<AmountofGroups(teamsize); i++){
			// 	System.out.println( "The " +(i+1) + " Team's happiness is: "+ TeamHappiness(i*teamsize,teamsize,choices));
			// }
	    	
	    	// SwapController(1,teamsize,choices,rollback);
	    	
	}


	public static void MainController(String[] args){
		GetUserArguments(args);
	    ReadInput();
	    IfequalGroups();
	    for (int i=0;i<swaprounds;i++){
	    	SwapController(swaptimes,teamsize,choices,rollback);
	    	StoreResult();
	    }
	    Output();
	}


	// public void RemoveDuplicate(String[] array, int choices){
	// 	for (int i = 0; i<choices-1; i++){
	// 		for (int j = i+1; j<choices; j++){
	// 			if (array[i] == array[j] && array[j] != "0"){
	// 				array[j] = "0";
	// 			}
	// 		}
	// 	}
	// }

	// public void RemoveSelf(String[] array, int choices){
	// 	for (int i = 0; i<6; i++){
	//     	for (int j = 0; j<3; j++){
	//     		if (StudentSet[i][j] == StudentName[i]){
	//     			StudentSet[i][j] ="0";
	//     		}
	//     	}
	//     }
	// }

	// calculate the Group number
	public static int ReturnGroupNumber(int index, int teamsize){ 
		return index / teamsize +1;
	}

	public static void IfequalGroups ()
	{
		if (Students % teamsize ==0){
			EqualGroups = true;
		}
		else{
			EqualGroups = false;
		}
	}

	public static int AmountofGroups(int teamsize){
		if (EqualGroups){
			return Students/teamsize;
		}
		else{
			return Students/teamsize +1;
		}
	}

	public static int AmountofPersoninGroups(int index){
		if (EqualGroups){
			return teamsize;
		}
		else if(Students-1-index >= teamsize){
			return teamsize;
		}
		else{
			return Students-index;
		}
	}

	public static String[] ReturnGroupMember(int index, int teamsize){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		String[] GroupMember = new String[10];
		int thisteamsize = AmountofPersoninGroups(index);
		int startpoint = (GroupNum -1) * teamsize;  //first position of groupmember
			for (int i = 0; i < thisteamsize; i++){
				GroupMember[i] = StudentName[i+startpoint];
			}
		
		return GroupMember;
	}

	public static int[] ReturnGroupMemberIndex(int index, int teamsize){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		int[] GroupMemberIndex = new int[10];
		int thisteamsize = AmountofPersoninGroups(index);
		int startpoint = (GroupNum -1) * teamsize;  //first position of groupmember
			for (int i = 0; i < thisteamsize; i++){
				GroupMemberIndex[i] = StudentIndex[i+startpoint];
			}
		
		return GroupMemberIndex;
	}

	public static int PersonalHappiness(int index, int teamsize, int choices){
		int[] GroupMemberIndex = ReturnGroupMemberIndex(index,teamsize);
		int happiness = 0;
		int ifhavezero = 0;
		if (StudentSet[index][0] == null){
			return AmountofPersoninGroups(index)-1;
		}
		for (int i = 0; i < choices; i++)
		{
			if (StudentSet[index][i] !=null){
				for (int j = 0; j < AmountofPersoninGroups(index); j++){
						if (StudentSet[index][i].equals(Integer.toString(GroupMemberIndex[j]))){
							happiness += choices-i;
						}
					}
			}
			// if (StudentSet[index][i] == "0"){
			// 		ifhavezero = 1;
			// 	}
		}
		return happiness;
		// TODO consider person have no choices and different choices
	}


	public static int TeamHappiness(int index, int teamsize, int choices){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		int startpoint = (GroupNum -1) * teamsize;
		int happiness = 0;
		for (int i = startpoint; i<startpoint+AmountofPersoninGroups(index); i++){
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
			int position1 = (int)getRandom(0,Students-1);
			int position2 = (int)getRandom(0,Students-1);
			int BackwardPercentage = (int)getRandom(0,100);
			if (BackwardPercentage <= percentage){
				//System.out.println( "Hit backwardButton" );
				return;
			}

			while (position1 == position2){
				position2 = (int)getRandom(0,Students-1);
			}

	    	String[] position1holder = new String[10];
	    	String[] position2holder = new String[10];
	    	String position1nameholder = StudentName[position1];
	    	String position2nameholder = StudentName[position2];
	    	int position1Indexholder = StudentIndex[position1];
	    	int position2Indexholder = StudentIndex[position2];
	    	// System.out.println( "position1 is" + Integer.toString(position1) );
	    	// System.out.println( "position2 is" + Integer.toString(position2) );

	    	for (int j=0; j<choices; j++){	
	    		for (int k=0; k<StudentSet[position1].length; k++){
	    			position1holder[j] = StudentSet[position1][j];
	    		}
	    		for (int k=0; k<StudentSet[position2].length; k++){
	    			position2holder[j] = StudentSet[position2][j];
	    		}
	    	}

	  //   	System.out.println( "position1holder is " + position1 );
	  //   	for (int a=0;a<3;a++){
	  //   		System.out.println( position1holder[a] );
	  //   	}
	    	
			// System.out.println( "position2holder is " + position2);
	  //   	for (int a=0;a<3;a++){
	  //   		System.out.println( position2holder[a] );
	  //   	}

	    	//temporary happiness and V
	    	int temphappiness = OverallHappiness(teamsize,choices);
	    	double tempvariance = Variance(teamsize,choices);
	    	// System.out.println( "temp OverallHappiness is" + Integer.toString(temphappiness) );
	    	// System.out.println( "temp Variance is" + Double.toString(tempvariance) );

	    	Swap(position1,position2);

	    	//happiness  and V after swap
	    	int swaphappiness = OverallHappiness(teamsize,choices);
	    	double swapvariance = Variance(teamsize,choices);

	  //   	for(int m=0; m<Students; m++)
	  //   	{
	  //   		System.out.println( StudentName[m] + "'s happiness is: "+ PersonalHappiness(m,teamsize,choices));
	  //   	}

	  //   	for (int m=0; m<AmountofGroups(teamsize); m++){
			// 	System.out.println( "The " +(m+1) + " Team's happiness is: "+ TeamHappiness(m*teamsize,teamsize,choices));
			// }

	  //   	System.out.println( "swap OverallHappiness is" + Integer.toString(swaphappiness) );
	  //   	System.out.println( "swap Variance is" + Double.toString(swapvariance) );


	    	// for (int a=0; a<Students; a++){
	    	// 	System.out.println( "Student: " + StudentName[a] );
	    	// 	if (StudentSet[a][0] !=null){	    			
		    // 		for (int b=0; b<choices; b++){
		    // 			if (StudentSet[a][b] != null){
		    // 				System.out.println( StudentSet[a][b] );
		    // 			}
		    // 		}
	    	// 	}
	    	// 	else{
	    	// 		System.out.println( "this set is NULL" );
	    	// 	}
	    	// 	System.out.println( "Next student" );
	    	// }


	    	// keep if Overall is higher
	    	if (swaphappiness > temphappiness && BackwardPercentage >20){
	    		//System.out.println( "Keep Result" );
	    		return;
	    	}
	    	else if (swaphappiness == temphappiness && swapvariance <= tempvariance){
	    		//System.out.println( "Equal happiness but lower or equal variance" );
	    		return;
	    	}
	    	else if (swaphappiness == temphappiness && swapvariance > tempvariance){
	    		//System.out.println( "Equal but higher variance" );
	    		StudentName[position1] = position1nameholder;
	    		StudentName[position2] = position2nameholder;
	    		StudentIndex[position1] = position1Indexholder;
	    		StudentIndex[position2] = position2Indexholder;
	    		StudentSet[position1] = position1holder;
	    		StudentSet[position2] = position2holder;
	    	}

	    	else{
	    		//System.out.println( "Keep Previous Result because new is lower " );
	    		StudentName[position1] = position1nameholder;
	    		StudentName[position2] = position2nameholder;
	    		StudentIndex[position1] = position1Indexholder;
	    		StudentIndex[position2] = position2Indexholder;
	    		StudentSet[position1] = position1holder;
	    		StudentSet[position2] = position2holder;
	    	}


	    	// for (int a=0; a<Students; a++){
	    	// 	System.out.println( "Student: " + StudentName[a] );
	    	// 	if (StudentSet[a].length !=0){	    			
		    // 		for (int b=0; b<choices; b++){
		    // 			if (StudentSet[a][b] != null){
		    // 				System.out.println( StudentSet[a][b] );
		    // 			}
		    // 		}
	    	// 	}
	    	// 	else{
	    	// 		System.out.println( "this set is NULL" );
	    	// 	}
	    	// 	System.out.println( "Next student" );
	    	// }

		}
	}

	//Swaping function to be called
	public static void Swap(int position1,int position2){

			String Nameholder = StudentName[position2];
			//make placeholder point to Position2
			String[] Choiceholder = StudentSet[position2];

			int Indexholder = StudentIndex[position2];
	    	//Swap
	    	StudentSet[position2] = StudentSet[position1];
	    	StudentSet[position1] = Choiceholder;

	    	StudentName[position2] = StudentName[position1];
	    	StudentName[position1] = Nameholder;

	    	StudentIndex[position2] = StudentIndex[position1];
	    	StudentIndex[position1] = Indexholder;

		return;
	}


	public static void StoreResult(){
		StudentNameStorage[StorageSize] = StudentName;
		StudentIndexStorage[StorageSize] = StudentIndex;
		StudentSetStorage[StorageSize] = StudentSet;
		VarianceStorage[StorageSize] = Variance(teamsize,choices);
		HappinessStorage[StorageSize] = OverallHappiness(teamsize,choices);

		StudentName = DefaultStudentName;
		StudentIndex = DefaultStudentIndex;
		StudentSet = DefaultStudentSet;
		StorageSize++;
	}


	public static int FindHighestHappiness(){
		int index = 0;
		for (int i=0; i<swaprounds-1; i++){
			if (HappinessStorage[i+1] > HappinessStorage[i]){
				index = i+1;
			}
		}
		HappinessStorage[index] = 0;
		// for (int i=0;i<Students; i++)
		// {
		// 	System.out.println("index is: " + Integer.toString(StudentIndexStorage[index][i]));
		// }

		// for (int i=0;i<Students; i++){
			
		// 	int[] a = ReturnGroupMemberIndex(i,teamsize);
		// 	for (int k=0; k<teamsize;k++)
		// 	{
		// 		System.out.print(a[k] +" , ");
		// 	}
		// 	System.out.println(StudentNameStorage[index][i] + "'s prefs: ");
		// 	for (int j=0;j<choices;j++){
		// 		System.out.println(StudentSetStorage[index][i][j]);
		// 	}
		// }
		return index;
	}

	public static int FindHighestVariance(){
		int index = 0;
		for (int i=0; i<swaprounds-1; i++){
			if (VarianceStorage[i+1] < VarianceStorage[i]){
				index = i+1;
			}
		}
		if (index == 0 && VarianceStorage[index] == 1000)
		{
			GoodVchoice = false;
			System.out.println("No more suitable groupings!");
		}
		VarianceStorage[index] = 1000;
		return index;
	}

	public static void PrintTempHighHappiness(){
		int index = FindHighestHappiness();
		StudentName = StudentNameStorage[index];
		StudentSet = StudentSetStorage[index];
		StudentIndex = StudentIndexStorage[index];

		// for (int i=0;i<Students; i++)
		// {
		// 	System.out.println("index is: " + Integer.toString(StudentIndex[i]));
		// }

		// for (int i=0;i<Students; i++){
			
		// 	int[] a = ReturnGroupMemberIndex(i,teamsize);
		// 	for (int k=0; k<teamsize;k++)
		// 	{
		// 		System.out.print(a[k] +" , ");
		// 	}
		// 	System.out.println(StudentName[i] + "'s prefs: ");
		// 	for (int j=0;j<choices;j++){
		// 		System.out.println(StudentSet[i][j]);
		// 	}
		// }

		System.out.println("Happy Team (" + OverallHappiness(teamsize,choices) + ")");
		for (int i=0; i<AmountofGroups(teamsize); i++){
			System.out.print( "Team " +(i+1) + " ("+ TeamHappiness(i*teamsize,teamsize,choices)+ "): ");
			for (int j=0; j<AmountofPersoninGroups(i*teamsize);j++){
					
				if (j == AmountofPersoninGroups(i*teamsize)-1){
					System.out.println(StudentName[j+i*teamsize] + " (" + PersonalHappiness(j+i*teamsize,teamsize,choices) + ")");
				}
				else{
					System.out.print(StudentName[j+i*teamsize] + " (" + PersonalHappiness(j+i*teamsize,teamsize,choices) + "), ");
				}
					
			}
		}
		System.out.println("The Variance is: " + Variance(teamsize,choices));
	}

	public static void PrintTempHighVariance(int happiness,double variance){
		int index = FindHighestVariance();
		StudentName = StudentNameStorage[index];
		StudentSet = StudentSetStorage[index];
		StudentIndex = StudentIndexStorage[index];
		if (OverallHappiness(teamsize,choices) >= 0.5* happiness && Variance(teamsize,choices) < variance){
			System.out.println("Happy Team (" + OverallHappiness(teamsize,choices) + ")");
			for (int i=0; i<AmountofGroups(teamsize); i++){
				System.out.print( "Team " +(i+1) + " ("+ TeamHappiness(i*teamsize,teamsize,choices)+ "): ");
				for (int j=0; j<AmountofPersoninGroups(i*teamsize);j++){
						
					if (j == AmountofPersoninGroups(i*teamsize)-1){
						System.out.println(StudentName[j+i*teamsize] + " (" + PersonalHappiness(j+i*teamsize,teamsize,choices) + ")");
					}
					else{
						System.out.print(StudentName[j+i*teamsize] + " (" + PersonalHappiness(j+i*teamsize,teamsize,choices) + "), ");
					}
						
				}
			}
			System.out.println("The Variance is: " + Variance(teamsize,choices));
		}
		else if (GoodVchoice == false)
		{
			return;
		}
		else{
			PrintTempHighVariance(happiness,variance);
		}
	}

	public static void Output(){

		if (verbosity == 4){
			System.out.println("Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			HappinessCompare = OverallHappiness(teamsize,choices);
			VarianceCompare = Variance(teamsize,choices);
			System.out.println("Second Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			System.out.println("Third Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			System.out.println("Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
			System.out.println("Second Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
		}
		if (verbosity == 3){
			System.out.println("Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			HappinessCompare = OverallHappiness(teamsize,choices);
			VarianceCompare = Variance(teamsize,choices);
			System.out.println("Second Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			System.out.println("Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
			System.out.println("Second Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
		}
		if (verbosity == 2){
			System.out.println("Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			HappinessCompare = OverallHappiness(teamsize,choices);
			VarianceCompare = Variance(teamsize,choices);
			System.out.println("Second Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			System.out.println("Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
		}
		if (verbosity == 1){
			System.out.println("Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
			HappinessCompare = OverallHappiness(teamsize,choices);
			VarianceCompare = Variance(teamsize,choices);
			System.out.println("Highest Oveall Variance Grouping is:");
			PrintTempHighVariance(HappinessCompare,VarianceCompare);
		}
		if (verbosity == 0){
			System.out.println("Highest Oveall Happiness Grouping is:");
			PrintTempHighHappiness();
		}
	}




}