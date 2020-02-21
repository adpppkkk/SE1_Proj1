package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    

	static String[] StudentName = {"A","B","C","D"};

	static String[] A = {"B","C","D"};
	static String[] B = {"A","C","D"};
	static String[] C = {"A","B","D"};
	static String[] D = {"A","B","C"};
	//happiness is 3,2,1

	static String[][] StudentSet= {A,B,C,D};


	public static void main( String[] args ){
	    for (int i = 0; i< 4; i++){
	    	System.out.println( StudentName[i] );
	    }
	}

	// calculate the Group number
	public int ReturnGroupNumber(int index, int teamsize){ 
		return index / teamsize +1;
	}

	public String[] ReturnGroupMember(int index, int teamsize){
		int GroupNum = ReturnGroupNumber(index,teamsize);
		String[] GourupMember = new String[10];

		int startpoint = (GroupNum -1) * teamsize;  //first position of groupmember
		int endpoint = GroupNum * teamsize -1;		//last 

		for (int i = 0; i < teamsize; i++){
			GourupMember[i] = StudentName[i+startpoint];
		}
		return GourupMember;
	}

	public int PersonalHappiness(int index, int teamsize, int choices){
		String[] GourupMember = ReturnGroupMember(index,teamsize);
		int happiness = 0;
		for (int i = 0; i < choices; i++)
		{
			for (int j = 0; j < teamsize; j++)
				{
					if (StudentSet[index][i] == GourupMember[j]){
						happiness += 3-i;
					}
				}
		}
		return happiness;
	}






}