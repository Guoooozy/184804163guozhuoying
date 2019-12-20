/**
 * @author Guoooozy
 * @date 2019/12/11 - 9:41
 * 各种检查
 */
public class Check {
    public boolean checkmoney(String money)//检查钱的输入是否为数字
    {
        if(money.length()>=10)
        {
            return false;
        }
        int number=Integer.valueOf(money);
        if(number<0)
            return false;
        for (int i = 0; i < money.length(); i++){
            if(money.charAt(i)<'0'||money.charAt(i)>'9')
                return  false;
        }
        return true;

    }

    public boolean checkcountname(String count)//检查账号和密码是否全英文或数字
    {
        for(int i=0;i<count.length();i++)
        {
            if((count.charAt(i)>='a'&&count.charAt(i)<='z'||count.charAt(i)>='A'&&count.charAt(i)<='Z'||count.charAt(i)>='0'&&count.charAt(i)<='9'))
                return false;

        }
        return true;
    }
/*
    public boolean check1(String name,String pwd)
    {
        UserMessage user=new UserMessage();
        if(user.find("name",name)[3].equals(pwd))
        {
            return true;
        }
        else
            return false;
    }

    public boolean check2(String acc)//存在返回true，不存在返回false
    {
        UserMessage user=new UserMessage();
        String s=user.find("acc",acc)[2];
        if(s.equals(acc))//找到相同名字返回true
            return true;
        else
            return false;//否则返回false
    }
}*/

    public boolean check1(String acc,String pwd)
    {
        UserMessage user=new UserMessage();
        if(user.find1(acc).equals(pwd))
            return true;
        else
            return false;
    }
    public boolean check2(String acc)
    {
        UserMessage user=new UserMessage();
        return user.find2(acc);
    }

}

