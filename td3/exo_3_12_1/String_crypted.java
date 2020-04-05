public class String_crypted
{
  // Attributs //
  private String originalStr;
  private int shift;
  private String strCryptee;

  // Methods //

  // Builder //
  String_crypted()
  {
    shift=0;
    originalStr="";
    strCryptee="";
  }

  String_crypted(String p_str, int p_shift)
  {
    shift=p_shift;
    originalStr=p_str;
    strCryptee="";
  }

  // private String_crypted(String str, int shift)
  // {
  //   String_crypted to_crypted(String strCryptee, int shift)
  //   {
  //     return new String_crypted(unshift(strCryptee, shift), shift);
  //   }

  //   String_crypted to_str(String str, int shift)
  //   {
  //     return new String_crypted(str, shift);
  //   }
  // }
  // end builder //

  String get_str()
  {
    if(originalStr=="")
      System.out.println("The string is empty.");
    return originalStr;
  }

  String get_strCryptee()
  {
    if(strCryptee=="")
      System.out.println("The string crypted is empty.");
    return strCryptee;
  }

  void set_new_str(String new_str)
  {
    System.out.println("Change the string.");
    originalStr=new_str;
  }

  char get_first_char()
  {
    return originalStr.charAt(0);
  }

  char get_char_x(int pos)
  {
    return originalStr.charAt(pos);
  }

  void reset_strCryptee()
  {
    System.out.println("\nReset string crypted.");
    strCryptee="";
  }

  void reset_str()
  {
    System.out.println("\nReset string");
    originalStr="";
  }

  String shift()
  {
    if(originalStr.isEmpty())
      return "";

    reset_strCryptee();

    System.out.println("\nCrypting in process...");
    for(int i=0; i<originalStr.length(); ++i)
    {
      char tmp=originalStr.charAt(i);
      int tmp2=(int) tmp;
      tmp2+=shift;
      tmp = (char) tmp2;
      String tmp3 = Character.toString(tmp);
      strCryptee+=tmp3;
    }
    return strCryptee;
  }

  String unshift()
  {
    reset_str();

    System.out.println("\nUncrypting in process...");
    for(int i=0; i<strCryptee.length(); ++i)
    {
      char tmp=strCryptee.charAt(i);
      int tmp2=(int) tmp;
      tmp2-=shift;
      tmp = (char) tmp2;
      String tmp3 = Character.toString(tmp);
      originalStr+=tmp3;
    }
    return originalStr;
  }

  void view_str()
  {
    if(originalStr.isEmpty())
      System.out.println("The string is empty.");
    else
      System.out.println("The string is " + this.originalStr);

    if(strCryptee.isEmpty())
      System.out.println("The string crypted is empty.");
    else
      System.out.println("The string crypted is " + this.strCryptee);

    System.out.println("Number of shifting: " + this.shift);
  }
}
