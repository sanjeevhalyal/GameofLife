
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class refreshcell {


    private Customsquare[][] CSarray;

    public refreshcell(Customsquare[][] csarray) {
        this.CSarray=csarray;
    }


    List<Customsquare> getsurrounding(Customsquare[][] CSarray, int I, int J)
    {
        int x=CSarray[0].length;
        int y=CSarray.length;
        List<Customsquare> rt=new LinkedList<Customsquare>();

        for(int i=I-1;i<=I+1;i++)
        {
            for(int j=J-1;j<=J+1;j++)
            {
                if(i>=0 && i<x && j>=0 && j<y && !(i==I && j==J))
                {
                    rt.add(CSarray[i][j]);
                }

            }
        }
        return rt;
    }

//    @Override
    public void run() {

            System.out.println("running");
        refresh();


    }

    private int refresh()
    {
        int x=CSarray[0].length;
        int y=CSarray.length;
        List<Customsquare> surrounding;
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                surrounding=getsurrounding(CSarray,i,j);

                Iterator<Customsquare> si= surrounding.iterator();
                int count=0;
                while(si.hasNext())
                {
                    Customsquare cs= si.next();
                    if(cs.isFlag())
                    {
                        count++;
                    }
                }
                Customsquare csupdate=CSarray[i][j];
                if(csupdate.isFlag())
                {
                    if(count==2 || count==3)
                    {
                        csupdate.setPrevious(true);
                    }
                    else
                    {
                        csupdate.setPrevious(false);
                    }
                }
                else if(count==3)
                {
                    csupdate.setPrevious(true);

                }
            }
        }

        int Alive=0;
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {

                Customsquare csupdate=CSarray[i][j];
                csupdate.setFlag(csupdate.isPrevious());
                if(csupdate.isPrevious())
                    Alive++;
            }
        }

        return Alive;
    }
}
