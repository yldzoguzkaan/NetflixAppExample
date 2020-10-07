import java.util.ArrayList;
import java.util.List;

import Controller.ProgramController;
import Controller.UserController;
import Model.Program;
import Model.User;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		UserController uc = new UserController();
//		Boolean a = uc.SearchUser("asd@burcu.com");
//		System.out.println(a);
		ProgramController pc = new ProgramController();
//		List<Integer> asd = new ArrayList<Integer>();
//		asd = pc.getKindIDByProgramID(1);
//		for (Integer integer : asd) {
//			System.out.println(integer);
//		}
//		List<Integer> retList = new ArrayList<Integer>();
//		retList = pc.getProgramIDByKind(2);
//		for (Integer integer : retList) {
//			System.out.println(integer);
//		}
		
//		System.out.println(pc.getProgramCount());
		
//		Program p = new Program();
//		p = pc.getProgramByID(1);
//		System.out.println(p.getKind().toString() + "\n" + p.toString());
		List<Integer> asd = new ArrayList<Integer>();
		List<Program> plist = new ArrayList<Program>();
		//asd = pc.SearchContentsByKind("c");
		//System.out.println(asd.size());
		List<Integer> programIDList = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		for (Integer integer : asd) {
			temp = pc.getProgramIDByKind(integer);
			for (Integer a : temp) {
				programIDList.add(a);
			}
			temp.clear();
		}
		for (Integer integer : programIDList) {
			plist.add(pc.getProgramByID(integer));
		}
		for (Program integer : plist) {
			System.out.println(integer.toString());
		}
		
	}

}
