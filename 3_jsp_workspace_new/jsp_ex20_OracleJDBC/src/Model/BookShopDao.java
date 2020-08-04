package Model;

import java.util.ArrayList;

public interface BookShopDao {
	public ArrayList<Dto> Show();
	public ArrayList<Dto> Search(Dto dto);
	public void Insert(Dto dto);
	public void Update(Dto dto);
	public void Delete(Dto dto);
}
