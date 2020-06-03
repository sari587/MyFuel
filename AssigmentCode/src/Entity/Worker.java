package Entity;
enum Job {
	stationmanager, networkadmin,marketingmanager
};

public class Worker extends Account{

private Job job;//8888

	public Worker(String username, String password, status stat, String name, String surname, String Email,Job job,int workernum) {
		super(username, password, Account.status.Worker, name, surname, workernum, Email, null, 0);
		// TODO Auto-generated constructor stub
		
		this.job=job;
	}



	public Job getJob() {
		return job;
	}

}
