
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class LibraryAp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        operating op = new operating();
        while (true) {
            String input = sc.nextLine();
            String[] tokens = input.split("[#|]");
            if(tokens[0].equals("add-library")){
                op.addLibrary(input);
            }
            else if(tokens[0].equals("add-category")){
                op.addCategory(input);
            }
            else if(tokens[0].equals("add-student")){
                op.addUser(input);
            }
            else if(tokens[0].equals("add-staff")){
                op.addUser(input);
            }
            else if(tokens[0].equals("add-manager")){
                op.addUser(input);
            }
            else if(tokens[0].equals("remove-user")){
                op.removeUser(input);
            }
            else if(tokens[0].equals("add-book")){
                op.addResource(input);
            }
            else if(tokens[0].equals("add-thesis")){
                op.addResource(input);
            }
            else if(tokens[0].equals("add-ganjineh-book")){
                op.addResource(input);
            }
            else if(tokens[0].equals("add-selling-book")){
                op.addResource(input);
            }
            else if(tokens[0].equals("remove-resource")){
                op.removeResource(input);
            }
            else if(tokens[0].equals("borrow")){
                op.borrow(input);
            }
            else if(tokens[0].equals("return")){
                op.returnbook(input);
            }
            else if(tokens[0].equals("buy")){
                op.buy(input);
            }
            else if(tokens[0].equals("read")){
                op.read(input);
            }
            else if(tokens[0].equals("add-comment")){
                op.addComment(input);
            }
            else if(tokens[0].equals("search-user")){
                op.SearchUser(input);
            }
            else if(tokens[0].equals("search")){
                op.search(input);
            }
            else if(tokens[0].equals("category-report")){
                op.categoryreport(input);
            }
            else if(tokens[0].equals("library-report")){
                op.libraryReport(input);
            }
            else if(tokens[0].equals("report-passed-deadline")){
                op.ReportPassedDeadline(input);
            }
            else if(tokens[0].equals("report-penalties-sum")){
                op.reportPenaltiesSum(input);
            }
            else if(tokens[0].equals("report-most-popular")){
                op.ReportMostPopular(input);
            }
            else if(tokens[0].equals("report-sell")){
                op.ReportSell(input);
            }
            else if(tokens[0].equals("finish")){
                System.out.println();
                return;
            }
        }

    }
}

class  operating{
    public void addLibrary(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if (!tokens[1].equals("admin")){
            System.out.println("permission-denied");
            return;
        }
        for(Library library: Data.libraries){
            if (tokens[3].equals(library.getId())){
                System.out.println("duplicate-id");
                return;
            }
        }
        Library newlibrary = new Library(tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6]), tokens[7]);
        Data.libraries.add(newlibrary);
        System.out.println("success");
    }

    public void  addCategory(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if (!tokens[1].equals("admin")){
            System.out.println("permission-denied");
            return;
        }
        boolean categoryFound = false;
        for(Category category: Data.categories){
            if(tokens[3].equals(category.getId())){
                categoryFound = true;
                break;
            }
        }
        if(categoryFound){
            System.out.println("duplicate-id");
            return;
        }
        boolean parentfound = false;
        if(tokens[5].equals("null")){
            parentfound = true;
        }
        else {
            for (Category category : Data.categories) {
                if (tokens[5].equals(category.getId())) {
                    parentfound = true;
                    break;
                }
            }
        }
        if(!parentfound){
            System.out.println("not-found");
            return;
        }
        System.out.println("success");
        Category category = new Category(tokens[3], tokens[4], tokens[5]);
        Data.categories.add(category);
    }

    public void addUser(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if (!tokens[1].equals("admin")){
            System.out.println("permission-denied");
            return;
        }
        boolean duplicate = false;
        for(User user:Data.users){
            if(user.getId().equals(tokens[3]) ){
                duplicate = true;
                break;
            }
        }
        if(duplicate){
            System.out.println("duplicate-id");
            return;
        }
        if(tokens[0].equals("add-student")){
            System.out.println("success");
            User newstudent= new Student(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]);
            Data.users.add(newstudent);
            return;
        }
        else if(tokens[0].equals("add-staff")){
            System.out.println("success");
            if(tokens[10].equals("staff")){
                User newstaff=new Staff(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]);
                Data.users.add(newstaff);
            }
            else if(tokens[10].equals("professor")){
                User newprofessor = new Professor(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]);
                Data.users.add(newprofessor);
            }
            return;
        }
        else if(tokens[0].equals("add-manager")){
            boolean libraryfound = false;
            for(Library library:Data.libraries){
                if(library.getId().equals(tokens[10]) ){
                    libraryfound = true;
                    break;
                }
            }
            if(!libraryfound){
                System.out.println("not-found");
                return;
            }
            System.out.println("success");
            User newmanager= new Manager(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10]);
            Data.users.add(newmanager);
            return;
        }
    }

    public void addResource(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        boolean libraryfound = false;
        boolean categoryfound = false;
        String libraryid = "";
        int x=0,y=0;
        if(tokens[0].equals("add-book") || tokens[0].equals("add-ganjineh-book")){
            x=10;
            y=9;
        }
        else if(tokens[0].equals("add-thesis")){
            x=9;
            y=8;
        }
        else if(tokens[0].equals("add-selling-book")){
            x=12;
            y=11;
        }
        for(Library library:Data.libraries){
            if(library.getId().equals(tokens[x]) ){
                libraryfound = true;
                libraryid = library.getId();
                break;
            }
        }
        if(!libraryfound){
            System.out.println("not-found");
            return;
        }
        for(Category category:Data.categories){
            if(category.getId().equals(tokens[y]) || tokens[y].equals("null") ){
                categoryfound = true;
                break;
            }
        }
        if(!categoryfound){
            System.out.println("not-found");
            return;
        }
        boolean permission = false;
        for(User user:Data.users){
            if(user instanceof Manager){
                if (user.getId().equals(tokens[1]) && ((Manager) user).getLibraryname().equals(tokens[x])){
                    permission = true;
                    break;
                }
            }
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        boolean duplicate = false;
        for(Resource resource:Data.resources){
            if(resource.getId().equals(tokens[3]) && resource.getLibrary().equals(libraryid)){
                duplicate = true;
                break;
            }
        }
        if(duplicate){
            System.out.println("duplicate-id");
            return;
        }

        if(tokens[0].equals("add-book")){
            System.out.println("success");
            Resource newbook = new Book(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],Integer.parseInt(tokens[8]),tokens[9],tokens[10]);
            Data.resources.add(newbook);
            return;
        }

        else if(tokens[0].equals("add-thesis")){
            System.out.println("success");
            Resource newthesis= new Thesis(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]);
            Data.resources.add(newthesis);
            return;
        }

       else if(tokens[0].equals("add-ganjineh-book")){
           System.out.println("success");
           Resource newganjineh = new GanjinehBook(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9],tokens[10]);
           Data.resources.add(newganjineh);
           return;
        }

       else if(tokens[0].equals("add-selling-book")){
           System.out.println("success");
           Resource newsellingbook = new SellingBook(tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],Integer.parseInt(tokens[8]),Integer.parseInt(tokens[9])
                   ,Integer.parseInt(tokens[10]),tokens[11],tokens[12]);
           Data.resources.add(newsellingbook);
           return;
        }
    }

    public void removeUser(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if (!tokens[1].equals("admin")){
            System.out.println("permission-denied");
            return;
        }
        boolean userfound = false;
        for(User user:Data.users){
            if(user.getId().equals(tokens[3]) ){
                userfound = true;
                break;
            }
        }
        if(!userfound){
            System.out.println("not-found");
            return;
        }
        for(User user:Data.users){
            if(user.getId().equals(tokens[3]) ){
                if(user.getPenalties()>0 || user.getBorrowtime()>0){
                    System.out.println("not-allowed");
                    return;
                }
            }
        }
        System.out.println("success");
        Iterator<User> iterator = Data.users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId().equals(tokens[3]) ){
                iterator.remove();
                break;
            }
        }
    }

    public void removeResource(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        String bookid=tokens[3];
        boolean resourcefound = false;
        for(Resource resource:Data.resources){
            if(resource.getId().equals(tokens[3]) && resource.getLibrary().equals(tokens[4])){
                resourcefound = true;
                break;
            }
        }
        if(!resourcefound){
            System.out.println("not-found");
            return;
        }

        boolean permission = false;
        for(User user:Data.users){
            if(user instanceof Manager){
                Manager manager = (Manager)user;
                if (manager.getId().equals(tokens[1]) && manager.getLibraryname().equals(tokens[4])){
                    permission = true;
                    break;
                }
            }
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }

        boolean borrow = false;
        for(BorrowRecord b:Data.borrowrecords){
            if(b.getBookid().equals(bookid) && b.getLibraryid().equals(tokens[4])){
                borrow = true;
                break;
            }
        }
        if(borrow){
            System.out.println("not-allowed");
            return;
        }
        System.out.println("success");
        Iterator<Resource> iterator = Data.resources.iterator();
        while(iterator.hasNext()){
            Resource resource = iterator.next();
            if(resource.getId().equals(tokens[3]) && resource.getLibrary().equals(tokens[4]) ){
                iterator.remove();
                break;
            }
        }
    }

    public void buy(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        boolean penalties = false;
        boolean ismanager = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPenalties() == 0) {
                        penalties = true;
                    }
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    if(user instanceof Manager){
                        ismanager = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean libraryfound = findlibrary(tokens[3]);
        if(!libraryfound){
            System.out.println("not-found");
            return;
        }
        boolean resourcefound = findresource(tokens[4],tokens[3]);
        if(!resourcefound){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!penalties){
            System.out.println("not-allowed");
            return;
        }
        boolean sellingbook = false;
        for(Resource resource:Data.resources){
            if(resource instanceof SellingBook ){
                SellingBook sellingBook = (SellingBook)resource;
                if(sellingBook.getId().equals(tokens[4]) && sellingBook.getLibrary().equals(tokens[3]) && sellingBook.getCopy()>0){
                    sellingbook=true;
                    sellingBook.setCopy(sellingBook.getCopy()-1);
                    break;
                }
            }
        }
        if(!sellingbook){
            System.out.println("not-allowed");
            return;
        }
        if(ismanager){
            System.out.println("permission-denied");
            return;
        }
        System.out.println("success");
        BuyRecord newrecord=new BuyRecord(tokens[1],tokens[2],tokens[3],tokens[4]);
        Data.buyRecords.add(newrecord);
        Log newlog=new Log(tokens[1],tokens[0],tokens[4],tokens[3],LocalDateTime.now());
        Data.logs.add(newlog);
    }

    public void read(String input){
        String[] tokens = input.split("[#|]");
        String[] parts= tokens[6].split(":");
        String hour = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String minute = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String[] date = tokens[5].split("-");
        String month = date[1].length() == 1 ? "0" + date[1] : date[1];
        String day = date[2].length() == 1 ? "0" + date[2] : date[2];
        String formattime=hour+":"+minute;
        String formatdate=date[0]+"-"+month+"-"+day;
        LocalDateTime getdate = LocalDateTime.parse(formatdate+"T"+formattime);
        boolean found = false;
        boolean pass = false;
        boolean permission = false;
        boolean penalties = true;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    if (user instanceof Professor) {
                        permission = true;
                    }
                    if (user.getPenalties() > 0) {
                        penalties = false;
                    }
                    break;
                }
            }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean resourcefound = false;
        boolean ganjineh=false;
        for(Resource resource:Data.resources){
            if(resource.getId().equals(tokens[4]) && resource.getLibrary().equals(tokens[3]) ) {
                resourcefound = true;
                if(resource instanceof GanjinehBook){
                    ganjineh=true;
                }
                break;
            }
        }
        if(!resourcefound){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        if(!ganjineh){
            System.out.println("not-allowed");
            return;
        }
        boolean isBookInUse = false;
        for (ReadRecord readRecord : Data.readRecords) {
            if (readRecord.getBookid().equals(tokens[4]) && readRecord.getLibraryid().equals(tokens[3])) {
                if (!getdate.isBefore(readRecord.getgetbook()) && getdate.isBefore(readRecord.getreturnbook())) {
                    isBookInUse = true;
                    break;
                }
            }
        }

        if (isBookInUse) {
            System.out.println("not-allowed");
            return;
        }
        if(!penalties){
            System.out.println("not-allowed");
            return;
        }
        System.out.println("success");
        LocalDateTime returntime = getdate.plusHours(2);
        ReadRecord newread=new ReadRecord(tokens[4],tokens[1],tokens[3],getdate,returntime);
        Data.readRecords.add(newread);
    }


    public void borrow(String input){
        String[] tokens = input.split("[#|]");
        String[] parts= tokens[6].split(":");
        String hour = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String minute = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String[] date = tokens[5].split("-");
        String month = date[1].length() == 1 ? "0" + date[1] : date[1];
        String day = date[2].length() == 1 ? "0" + date[2] : date[2];
        String formattime=hour+":"+minute;
        String formatdate=date[0]+"-"+month+"-"+day;
        LocalDateTime getdate = LocalDateTime.parse(formatdate+"T"+formattime);
        boolean found = false;
        boolean pass = false;
        boolean penalty = false;
        boolean borrowtime = false;
        boolean resourcefound = false;
        boolean isbook=false;
        boolean copy=false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        for(User user:Data.users){
            if (user.getId().equals(tokens[1])) {
                found = true;
                if(user.getPenalties()==0){
                    penalty=true;
                }
                if(user instanceof Professor || user instanceof  Staff || user instanceof Manager ){
                    if(user.getBorrowtime()<5){
                        borrowtime=true;
                    }
                }
                if(user instanceof Student){
                    if (user.getBorrowtime()<3){
                        borrowtime=true;
                    }
                }
                if (user.getPassword().equals(tokens[2])) {
                    pass = true;
                }
                break;
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean libraryfound = findlibrary(tokens[3]);
        if(!libraryfound){
            System.out.println("not-found");
            return;
        }
        for(Resource resource:Data.resources){
            if(resource.getId().equals(tokens[4]) && resource.getLibrary().equals(tokens[3])) {
                resourcefound = true;
                if(resource.getCopy()==0){
                    copy=true;
                }
                isbook=resource instanceof SellingBook || resource instanceof GanjinehBook;
                break;
            }
        }
        if(!resourcefound){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!penalty){
            System.out.println("not-allowed");
            return;
        }
        if(isbook){
            System.out.println("not-allowed");
            return;
        }
        if(copy){
            System.out.println("not-allowed");
            return;
        }
        if(!borrowtime){
            System.out.println("not-allowed");
            return;
        }
        boolean borrowonce = false;
        for(BorrowRecord borrowRecord:Data.borrowrecords){
            if (borrowRecord.getStudentid().equals(tokens[1]) && borrowRecord.getLibraryid().equals(tokens[3]) && borrowRecord.getBookid().equals(tokens[4])) {
                borrowonce=true;
                break;
            }
        }
        if(borrowonce){
            System.out.println("not-allowed");
            return;
        }
        System.out.println("success");
        BorrowRecord newborrow=new BorrowRecord(tokens[1],tokens[2],tokens[3],tokens[4],getdate);
        Data.borrowrecords.add(newborrow);
        for (User user:Data.users){
            if (user.getId().equals(tokens[1])) {
                user.setBorrowtime(user.getBorrowtime()+1);
            }
        }
        for (Resource resource:Data.resources){
            if (resource.getId().equals(tokens[4]) && resource.getLibrary().equals(tokens[3])) {
                resource.setCopy(resource.getCopy()-1);
            }
        }
        Log log=new Log(tokens[1],tokens[0],tokens[4],tokens[3],getdate);
        Data.logs.add(log);
    }


  public void returnbook(String input){
      String[] tokens = input.split("[#|]");
      String[] parts= tokens[6].split(":");
      String hour = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
      String minute = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
      String[] date = tokens[5].split("-");
      String month = date[1].length() == 1 ? "0" + date[1] : date[1];
      String day = date[2].length() == 1 ? "0" + date[2] : date[2];
      String formattime=hour+":"+minute;
      String formatdate=date[0]+"-"+month+"-"+day;
      LocalDateTime getdate = LocalDateTime.parse(formatdate+"T"+formattime);
      boolean found = false;
      boolean pass=false;
      boolean isstudent = false;
      boolean isstaff = false;
      boolean resourcefound = false;
      boolean isbook=false;
      boolean isthesis=false;
      if(tokens[1].equals("admin")){
          found = true;
          if(tokens[2].equals("AdminPass")){
              pass = true;
          }
      }
      for(User user:Data.users){
          if (user.getId().equals(tokens[1])) {
              found = true;
              if (user instanceof Student) {
                  isstudent = true;
              }
              if (user instanceof Staff || user instanceof Professor  || user instanceof Manager ) {
                  isstaff = true;
              }
              if (user.getPassword().equals(tokens[2])) {
                  pass = true;
              }
              break;
          }
      }
      if(!found){
          System.out.println("not-found");
          return;
      }
      boolean libraryfound=findlibrary(tokens[3]);
      if(!libraryfound){
          System.out.println("not-found");
          return;
      }
      for(Resource resource:Data.resources){
          if (resource.getId().equals(tokens[4]) && resource.getLibrary().equals(tokens[3])) {
              if(resource instanceof Book ){
                  resourcefound = true;
                  isbook=true;
              }
              if(resource instanceof Thesis){
                  resourcefound = true;
                  isthesis=true;
              }
              break;
          }
      }
      if(!resourcefound){
          System.out.println("not-found");
          return;
      }
      boolean isborrow= false;
      boolean success = false;
      long min=0;
      for(BorrowRecord borrowRecord:Data.borrowrecords){
          if(borrowRecord.getStudentid().equals(tokens[1]) && borrowRecord.getLibraryid().equals(tokens[3]) && borrowRecord.getBookid().equals(tokens[4])) {
              min= ChronoUnit.MINUTES.between(borrowRecord.getBorrowdate(),getdate);
              isborrow=true;
              break;
          }
      }
      if(!isborrow){
          System.out.println("not-found");
          return;
      }
      if(!pass){
          System.out.println("invalid-pass");
          return;
      }
      long timepenalty=min/60;
      long penalty=0;
      for (BorrowRecord borrowRecord:Data.borrowrecords){
          if (borrowRecord.getStudentid().equals(tokens[1]) && borrowRecord.getLibraryid().equals(tokens[3]) && borrowRecord.getBookid().equals(tokens[4])) {
              if(isstudent){
                  if (isbook){
                      if(timepenalty>10*24){
                          penalty=(timepenalty-10*24)*50;
                          System.out.println(penalty);
                      }
                      else {
                          success=true;
                      }
                  }
                  else if(isthesis){
                      if(timepenalty>7*24){
                          penalty=(timepenalty-7*24)*50;
                          System.out.println(penalty);
                      }
                      else {
                          success=true;
                      }
                  }
              }
              if(isstaff){
                  if(isbook){
                      if(timepenalty>14*24){
                          penalty=(timepenalty-14*24)*100;
                          System.out.println(penalty);
                      }
                      else {
                          success=true;
                      }
                  }
                  if(isthesis){
                      if(timepenalty>10*24){
                          penalty=(timepenalty-10*24)*100;
                          System.out.println(penalty);
                      }
                      else {
                          success=true;
                      }
                  }
              }
              break;
          }
      }
      for(Resource resource:Data.resources){
          if (resource.getId().equals(tokens[4]) && resource.getLibrary().equals(tokens[3])) {
              resource.setCopy(resource.getCopy()+1);
          }
      }
      for(User user:Data.users){
          if (user.getId().equals(tokens[1])) {
              user.setBorrowtime(user.getBorrowtime()-1);
              if (penalty>0) {
                  user.setPenalties(user.getPenalties() +(int)penalty);
              }
          }
      }
      Iterator<BorrowRecord> iterator = Data.borrowrecords.iterator();
      while(iterator.hasNext()){
          BorrowRecord borrowRecord = iterator.next();
          if (borrowRecord.getStudentid().equals(tokens[1]) && borrowRecord.getLibraryid().equals(tokens[3]) && borrowRecord.getBookid().equals(tokens[4])){
              iterator.remove();
              break;
          }
      }
      Log log=new Log(tokens[1],tokens[0],tokens[4],tokens[3],getdate);
      Data.logs.add(log);
      if(success){
          System.out.println("success");
          return;
      }
  }

    public void search(String input){
        String[] tokens = input.split("[#|]");
        ArrayList<String> bookids = new ArrayList<>();
        String search=tokens[1].toLowerCase();
        for(Resource resource:Data.resources){
            String name=resource.getName().toLowerCase();
            String Author=resource.getAuthor().toLowerCase();
        if(name.contains(search) || Author.contains(search) ){
                bookids.add(resource.getId());
                continue;
            }
            if (resource instanceof Thesis){
                Thesis thesis2=(Thesis)resource;
                String nameprofessor=thesis2.getProfessorname().toLowerCase();
                if(nameprofessor.contains(search)){
                    bookids.add(resource.getId());
                    continue;
                }
            }
            else {
                if(resource instanceof Book ){
                    Book book2=(Book)resource;
                    String publishername=book2.getPublisher().toLowerCase();
                    if(publishername.contains(search)){
                        bookids.add(resource.getId());
                        continue;
                    }
                }
                else if(resource instanceof GanjinehBook ){
                    GanjinehBook book2=(GanjinehBook)resource;
                    String publishername=book2.getPublisher().toLowerCase();
                    if(publishername.contains(search)){
                        bookids.add(resource.getId());
                        continue;
                    }
                }
                else if(resource instanceof SellingBook ){
                    SellingBook book2=(SellingBook)resource;
                    String publishername=book2.getPublisher().toLowerCase();
                    if(publishername.contains(search)){
                        bookids.add(resource.getId());
                        continue;
                    }
                }
            }
        }
        if(bookids.isEmpty()){
            System.out.println("not-found");
            return;
        }
        Collections.sort(bookids);
        System.out.println(String.join("|",bookids));
    }





    public void SearchUser(String input){
        String[] tokens = input.split("[#|]");
        ArrayList<String> name=new ArrayList<>();
        boolean found = false;
        boolean pass = false;
        boolean permission = true;
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    if(user instanceof Student){
                        permission=false;
                    }
                    break;
                }
            }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        for(User user:Data.users){
            String Username=user.getName().toLowerCase();
            String Lastname=user.getLastname().toLowerCase();
            if(Username.contains(tokens[3].toLowerCase()) || Lastname.contains(tokens[3].toLowerCase())){
                name.add(user.getId());
            }
        }
        if (name.isEmpty()) {
            System.out.println("not-found");
            return;
        }
        Collections.sort(name);
        System.out.println(String.join("|",name));
    }



    public void libraryReport(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        boolean permission = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        for (User user : Data.users) {
            if (user.getId().equals(tokens[1])) {
                found = true;
                if (user.getPassword().equals(tokens[2])) {
                    pass = true;
                }
                if(user instanceof Manager && ((Manager) user).getLibraryname().equals(tokens[3])){
                    permission = true;
                }
                break;
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        boolean libraryexist = findlibrary(tokens[3]);
        if(!libraryexist){
            System.out.println("not-found");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        int allbook=0;
        int allthesis=0;
        int borrowbook=0;
        int borrowthesis=0;
        int ganjineh=0;
        int sellingbook=0;
        for(Resource resource:Data.resources){
            if(resource.getLibrary().equals(tokens[3])){
                if(resource instanceof Book){
                    allbook+=resource.getCopy();
                }
                else if(resource instanceof Thesis){
                    allthesis+=resource.getCopy();
                }
                else if(resource instanceof GanjinehBook){
                    ganjineh++;
                }
                else if(resource instanceof SellingBook){
                    sellingbook+=resource.getCopy();
                }
            }
        }
        for(BorrowRecord borrowRecord:Data.borrowrecords){
            if (borrowRecord.getLibraryid().equals(tokens[3])) {
                for(Resource resource:Data.resources){
                    if(resource.getId().equals(borrowRecord.getBookid()) && resource.getLibrary().equals(borrowRecord.getLibraryid())){
                        if(resource instanceof Book){
                            borrowbook++;
                        }
                        else if(resource instanceof Thesis){
                            borrowthesis++;
                        }
                    }
                }
            }
        }
        System.out.println(allbook+" "+allthesis+" "+borrowbook+" "+borrowthesis+" "+ganjineh+" "+sellingbook);
    }


    public void addComment(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass = false;
        boolean permission = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        for (User user : Data.users) {
            if (user.getId().equals(tokens[1])) {
                found = true;
                if (user.getPassword().equals(tokens[2])) {
                    pass = true;
                }
                if(user instanceof Student || user instanceof Professor) {
                    permission = true;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean foundLibrary=findlibrary(tokens[3]);
        if(!foundLibrary){
            System.out.println("not-found");
            return;
        }
        boolean resourceexist = findresource(tokens[4],tokens[3]);
        if(!resourceexist){
            System.out.println("not-found");
            return;
        }
        if (!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        System.out.println("success");
        Comment newcomment=new Comment(tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
        Data.comments.add(newcomment);
    }

    public void categoryreport(String input){
        String[] tokens = input.split("[#|]");
        boolean found=false;
        boolean pass=false;
        boolean permission=false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        for (User user : Data.users) {
            if (user.getId().equals(tokens[1])) {
                found = true;
                if (user.getPassword().equals(tokens[2])) {
                    pass = true;
                }
                if(user instanceof Manager && ((Manager) user).getLibraryname().equals(tokens[4])) {
                    permission = true;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        boolean foundlibrray = findlibrary(tokens[4]);
        if(!foundlibrray){
            System.out.println("not-found");
            return;
        }
        boolean foundcategory = false;
        for(Category category:Data.categories){
            if(category.getId().equals(tokens[3]) || tokens[3].equals("null")){
                foundcategory = true;
                break;
            }
        }
        if(!foundcategory){
            System.out.println("not-found");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        int allbook=0;
        int allthesis=0;
        int ganjineh=0;
        int sellingbook=0;
        HashSet<String> subcatgeory = new HashSet<>();
        if(tokens[3].equals("null")){
            String namecategory="null";
            for(Resource resource:Data.resources){
                if(resource.getCategory().equals(namecategory) && resource.getLibrary().equals(tokens[4])){
                    if(resource instanceof Book){
                        allbook+=resource.getCopy();
                    }
                    else if(resource instanceof Thesis){
                        allthesis+=resource.getCopy();
                    }
                    else if(resource instanceof GanjinehBook){
                        ganjineh++;
                    }
                    else if(resource instanceof SellingBook){
                        sellingbook+=resource.getCopy();
                    }
                }
            }
        }
        else {
            subcatgeory.add(tokens[3]);
            int a = 0, b = 1;
            while (a != b) {
                a = subcatgeory.size();
                for (Category category : Data.categories) {
                    if (category.getParent().equals("null")) {
                        continue;
                    }
                    if (subcatgeory.contains(category.getParent())) {
                        subcatgeory.add(category.getId());
                    }
                }
                b = subcatgeory.size();
            }
            for (Resource resource : Data.resources) {
                if (resource.getLibrary().equals(tokens[4]) && subcatgeory.contains(resource.getCategory())) {
                    if (resource instanceof Book) {
                        allbook += resource.getCopy();
                    } else if (resource instanceof Thesis) {
                        allthesis += resource.getCopy();
                    } else if (resource instanceof GanjinehBook) {
                        ganjineh++;
                    } else if (resource instanceof SellingBook) {
                        sellingbook += resource.getCopy();
                    }
                }
            }
        }
        System.out.println(allbook+" "+allthesis+" "+ganjineh+" "+sellingbook);
    }



    public void ReportPassedDeadline(String input){
        String[] tokens = input.split("[#|]");
        String[] parts= tokens[5].split(":");
        String hour = parts[0].length() == 1 ? "0" + parts[0] : parts[0];
        String minute = parts[1].length() == 1 ? "0" + parts[1] : parts[1];
        String[] date = tokens[4].split("-");
        String month = date[1].length() == 1 ? "0" + date[1] : date[1];
        String day = date[2].length() == 1 ? "0" + date[2] : date[2];
        String formattime=hour+":"+minute;
        String formatdate=date[0]+"-"+month+"-"+day;
        LocalDateTime getdate = LocalDateTime.parse(formatdate+"T"+formattime);
        boolean found = false;
        boolean pass = false;
        boolean permission = false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        for (User user : Data.users) {
            if (user.getId().equals(tokens[1])) {
                found = true;
                if (user.getPassword().equals(tokens[2])) {
                    pass = true;
                }
                if(user instanceof Manager && ((Manager) user).getLibraryname().equals(tokens[3])){
                    permission = true;
                }
                break;
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        boolean libraryexist = findlibrary(tokens[3]);
        if(!libraryexist){
            System.out.println("not-found");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        HashSet<String> ids = new HashSet<>();
        boolean isbook=false,isthesis=false;
        for(BorrowRecord borrowRecord:Data.borrowrecords){
            if(borrowRecord.getLibraryid().equals(tokens[3])){
                LocalDateTime borrowtime = borrowRecord.getBorrowdate();
                boolean resourcefound = false;
                isbook=false;
                isthesis=false;
                for(Resource resource:Data.resources){
                    if(resource.getId().equals(borrowRecord.getBookid()) && resource.getLibrary().equals(tokens[3])){
                         isbook= resource instanceof Book;
                         isthesis= resource instanceof Thesis;
                         resourcefound = true;
                        break;
                    }
                }
                if(!resourcefound){
                    continue;
                }
                boolean userfound = false;
                for(User user:Data.users){
                    if(user.getId().equals(borrowRecord.getStudentid())){
                        userfound = true;
                        if(user instanceof Student){
                            if(isbook){
                                borrowtime=borrowtime.plusDays(10);
                            }
                            else if(isthesis){
                                borrowtime=borrowtime.plusDays(7);
                            }
                        }
                        if(user instanceof Staff || user instanceof Manager || user instanceof Professor){
                            if(isbook){
                                borrowtime=borrowtime.plusDays(14);
                            }
                            else if(isthesis){
                                borrowtime=borrowtime.plusDays(10);
                            }
                        }
                        break;
                    }
                }
                if(!userfound){
                    continue;
                }
                if(getdate.isAfter(borrowtime)){
                    ids.add(borrowRecord.getBookid());
                }
            }
        }
        if(ids.isEmpty()){
            System.out.println("none");
            return;
        }
        List<String> list = new ArrayList<>(ids);
        Collections.sort(list);
        System.out.println(String.join("|",list));
    }


    public void reportPenaltiesSum(String output){
        String[] tokens = output.split("[#|]");
        boolean found = false;
        boolean pass=false;
        boolean permission=false;
        if(tokens[1].equals("admin")){
            found = true;
            permission=true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        long sum=0;
        for(User user:Data.users){
            if(user.getPenalties()>0){
                sum+=user.getPenalties();
            }
        }
        System.out.println(sum);
    }


    public boolean findresource(String idresource ,String library){
        for(Resource resource:Data.resources) {
        if(resource.getId().equals(idresource) && resource.getLibrary().equals(library)){
            return true;
        }
        }
        return false;
    }

    public boolean findlibrary(String id){
        for(Library library:Data.libraries){
            if(library.getId().equals(id)){
                return true;
            }
        }
        return false;
    }




    public void ReportMostPopular(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass=false;
        boolean permission=false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    if (user instanceof Manager && ((Manager) user).getLibraryname().equals(tokens[3])) {
                        permission = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean libraryexist = findlibrary(tokens[3]);
        if(!libraryexist){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        String idbook="null";
        String idthesis="null";
        int bookborrow=0;
        int thesisborrow=0;
        int daysborrowbook=0;
        int daysborrowthesis=0;
        for(Log log:Data.logs){
            if(log.getLibraryid().equals(tokens[3]) && log.getCommand().equals("borrow")) {
                for (Resource resource : Data.resources) {
                    if (resource.getId().equals(log.getBookid()) && resource.getLibrary().equals(tokens[3])) {
                        for (Log log2 : Data.logs) {
                            if (log2.getTime().isBefore(log.getTime())) {
                                continue;
                            } else if (log2.getCommand().equals("return") && log2.getBookid().equals(log.getBookid()) && log2.getLibraryid().equals(log.getLibraryid()) && log2.getIdstudent().equals(log.getIdstudent())) {
                                if (resource instanceof Book) {
                                    ((Book) resource).setNumborrow(((Book) resource).getNumborrow() + 1);
                                    long hour = ChronoUnit.MINUTES.between(log.getTime(), log2.getTime());
                                    ((Book) resource).setHour(((Book) resource).getHour() + (int) hour);
                                } else if (resource instanceof Thesis) {
                                    ((Thesis) resource).setNumborrow(((Thesis) resource).getNumborrow() + 1);
                                    long hour = ChronoUnit.MINUTES.between(log.getTime(), log2.getTime());
                                    ((Thesis) resource).setHour(((Thesis) resource).getHour() + (int) hour);
                                }
                            }
                        }
                    }
                }

                }
            }
        for(Resource resource:Data.resources){
            if(resource instanceof Book){
                if(((Book) resource).getHour()>daysborrowbook){
                    daysborrowbook=((Book) resource).getHour();
                    idbook=((Book) resource).getId();
                    bookborrow=((Book) resource).getNumborrow();
                }
            }
            else if(resource instanceof Thesis){
                if(((Thesis) resource).getHour()>daysborrowthesis){
                    daysborrowthesis=((Thesis) resource).getHour();
                    idthesis=((Thesis) resource).getId();
                    thesisborrow=((Thesis) resource).getNumborrow();
                }
            }
        }
        for(Resource resource:Data.resources){
            if(resource instanceof Book book){
                book.setNumborrow(0);
                book.setHour(0);
            }
            else if(resource instanceof Thesis thesis){
                thesis.setNumborrow(0);
                thesis.setHour(0);
            }
        }

        if (idbook.equals("null")){
            System.out.println("null");
        }
        if (!idbook.equals("null")){
            System.out.println(idbook+" "+bookborrow+" "+(int) Math.ceil((double) (daysborrowbook/1440.0)));
        }
        if (idthesis.equals("null")){
            System.out.println("null");
        }
        if(!idthesis.equals("null")){
            System.out.println(idthesis+" "+thesisborrow+" "+ (int) Math.ceil((double) (daysborrowthesis/1440.0)));
        }
    }

    public void ReportSell(String input){
        String[] tokens = input.split("[#|]");
        boolean found = false;
        boolean pass=false;
        boolean permission=false;
        if(tokens[1].equals("admin")){
            found = true;
            if(tokens[2].equals("AdminPass")){
                pass = true;
            }
        }
        else {
            for (User user : Data.users) {
                if (user.getId().equals(tokens[1])) {
                    found = true;
                    if (user.getPassword().equals(tokens[2])) {
                        pass = true;
                    }
                    if (user instanceof Manager && ((Manager) user).getLibraryname().equals(tokens[3])) {
                        permission = true;
                    }
                    break;
                }
            }
        }
        if(!found){
            System.out.println("not-found");
            return;
        }
        boolean libraryexist = findlibrary(tokens[3]);
        if(!libraryexist){
            System.out.println("not-found");
            return;
        }
        if(!pass){
            System.out.println("invalid-pass");
            return;
        }
        if(!permission){
            System.out.println("permission-denied");
            return;
        }
        int numall=0;
        int priceall=0;
        for(Log log:Data.logs){
            if(log.getLibraryid().equals(tokens[3]) && log.getCommand().equals("buy")) {
                numall++;
                for (Resource resource : Data.resources) {
                    if (resource.getId().equals(log.getBookid()) && resource.getLibrary().equals(tokens[3])) {
                        if (resource instanceof SellingBook) {
                            ((SellingBook) resource).setNumsell(((SellingBook) resource).getNumsell() + 1);
                            priceall+=(int)(((SellingBook) resource).getPrice()-((SellingBook) resource).getPrice()*((double)((SellingBook) resource).getDiscount()/100.0));
                        }
                    }
                }
            }
        }
        if(priceall==0){
            System.out.println("null");
            return;
        }
        else {
            System.out.println(numall +" "+priceall);
        }
        int maxnum=0;
        int price=0;
        String Id="null";
        for(Resource resource:Data.resources){
            if (resource instanceof SellingBook sellingBook) {
                if(sellingBook.getNumsell()>maxnum){
                    maxnum=sellingBook.getNumsell();
                    price=maxnum*(int)(((SellingBook) resource).getPrice()-(((SellingBook) resource).getPrice()*((double)((SellingBook) resource).getDiscount()/100.0)));
                    Id=sellingBook.getId();
                }
            }
        }
        for(Resource resource:Data.resources){
            if(resource instanceof SellingBook sellingBook) {
                sellingBook.setNumsell(0);
            }
        }
        System.out.println(Id+" "+maxnum+" "+price);
    }
}

class Data{
    public static ArrayList<Resource> resources = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Library> libraries = new ArrayList<>();
    public static ArrayList<Category> categories = new ArrayList<>();
    public static ArrayList<Comment> comments = new ArrayList<>();
    public static ArrayList<BorrowRecord> borrowrecords = new ArrayList<>();
    public static ArrayList<BuyRecord> buyRecords = new ArrayList<>();
    public static ArrayList<ReadRecord> readRecords = new ArrayList<>();
    public static ArrayList<Log> logs = new ArrayList<>();
}

  abstract class Resource{
    protected String id;
    protected String name;
    protected String author;
    protected String age;
    protected String category;
    protected String library;
    protected int copy;
    public Resource(String id, String name, String author, String age, String category, String library) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.age = age;
        this.category = category;
        this.library = library;
    }
    public String getId() {
        return id;
    }
    public String getCategory() {
        return category;
    }
    public String getLibrary() {
        return library;
    }
    public int getCopy() {
        return copy;
    }
    public void setCopy(int copy) {
        this.copy = copy;
    }
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
}

 class Book extends Resource{
    private String publisher;
    private int hour;
    private int numborrow;
    public Book(String id, String name, String author,String publisher ,String age,int copy ,String category, String library) {
        super(id,name,author,age,category,library);
        this.publisher = publisher;
        this.copy = copy;
        this.hour =0;
        this.numborrow =0;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getNumborrow() {
        return numborrow;
    }
    public void setNumborrow(int numborrow) {
        this.numborrow = numborrow;
    }
}

class Thesis extends Resource{
    private String professorname;
    private int hour;
    private int numborrow;
    public Thesis(String id, String name, String author,String professorname ,String age, String category, String library) {
        super(id,name,author,age,category,library);
        this.professorname = professorname;
        this.copy = 1;
        this.hour =0;
        this.numborrow =0;
    }
    public String getProfessorname() {
        return professorname;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getHour() {
        return hour;
    }
    public void setNumborrow(int numborrow) {
        this.numborrow = numborrow;
    }
    public int getNumborrow() {
        return numborrow;
    }
}

class GanjinehBook extends Resource{
    private String publisher;
    private String donator;
    public GanjinehBook(String id, String name, String author,String publisher ,String age,String donator,String category, String library) {
        super(id,name,author,age,category,library);
        this.publisher = publisher;
        this.copy = 1;
        this.donator = donator;
    }
    public String getPublisher() {
        return publisher;
    }
}

class SellingBook extends Resource{
    private String publisher;
    private int price;
    private int discount;
    private int numsell;
    public SellingBook(String id, String name, String author,String publisher ,String age,int copy,int price,int discount,String category, String library) {
        super(id,name,author,age,category,library);
        this.publisher = publisher;
        this.copy = copy;
        this.price = price;
        this.discount = discount;
        this.numsell =0;
    }
    public int getPrice() {
        return price;
    }
    public int getDiscount() {
        return discount;
    }
    public String getPublisher() {
        return publisher;
    }
    public int getNumsell() {
        return numsell;
    }
    public void setNumsell(int numsell) {
        this.numsell = numsell;
    }
}

abstract class User{
    protected String id;
    protected String password;
    protected String name;
    protected String lastname;
    protected String codemeli;
    protected String age;
    protected String address;
    protected int borrowtime;
    protected int penalties;
    public User(String id, String password, String name, String lastname, String codemeli, String age, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.codemeli = codemeli;
        this.age = age;
        this.address = address;
        this.borrowtime = 0;
        this.penalties = 0;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public int getBorrowtime() {
        return borrowtime;
    }
    public int getPenalties() {
        return penalties;
    }
    public void setBorrowtime(int borrowtime) {
        this.borrowtime = borrowtime;
    }
    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
}


class Student extends User {
    public Student(String id, String password, String name, String lastname,String codemeli ,String age, String address) {
        super(id, password, name, lastname, codemeli, age, address);
    }
}


class Staff extends User {
    public Staff(String id, String password, String name, String lastname,String codemeli ,String age, String address) {
        super(id, password, name, lastname, codemeli, age, address);
    }
}

class Professor extends User {
    public Professor(String id, String password, String name, String lastname,String codemeli ,String age, String address) {
        super(id, password, name, lastname, codemeli, age, address);
    }

}


class Manager extends User{
    private String libraryname;
    public Manager(String id, String password, String name, String lastname,String codemeli ,String age, String address, String libraryname) {
        super(id, password, name, lastname, codemeli, age, address);
        this.libraryname = libraryname;
    }
    public String getLibraryname() {
        return libraryname;
    }
}


class Category{
    private String id;
    private String name;
    private String parent;
    public Category(String id, String name, String parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }
    public String getParent(){
        return parent;
    }
    public String getId() {
        return id;
    }

}

class Library{
    private String id;
    private final String name;
    private String years;
    private final int tables;
    private final String address;
    public Library(String id, String name, String years, int tables, String address) {
        this.id = id;
        this.name = name;
        this.years = years;
        this.tables = tables;
        this.address = address;
    }
    public String getId() {
        return id;
    }
    public int getTables() {
        return tables;
    }
}

class BorrowRecord{
    private String Studentid;
    private String pass;
    private String libraryid;
    private String bookid;
    private LocalDateTime borrowdate;
    public BorrowRecord(String Studentid,String pass ,String libraryid, String bookid, LocalDateTime borrowdate) {
        this.Studentid = Studentid;
        this.pass = pass;
        this.libraryid = libraryid;
        this.bookid = bookid;
        this.borrowdate = borrowdate;
    }
    public String getPass(){
        return pass;
    }
    public String getBookid() {
        return bookid;
    }
    public String getLibraryid() {
        return libraryid;
    }
    public LocalDateTime getBorrowdate() {
        return borrowdate;
    }
    public String getStudentid() {
        return Studentid;
    }
}

class BuyRecord{
    private String studentid;
    private String pass;
    private String Libraryid;
    private String bookid;
    public BuyRecord(String studentid, String pass, String Libraryid, String bookid) {
        this.studentid = studentid;
        this.pass = pass;
        this.Libraryid = Libraryid;
        this.bookid = bookid;
    }

}
class ReadRecord{
    private String bookid;
    private String studentid;
    private String libraryid;
    private LocalDateTime getbook;
    private LocalDateTime returnbook;
    public ReadRecord(String bookid, String studentid, String libraryid, LocalDateTime getbook, LocalDateTime returnbook) {
        this.bookid = bookid;
        this.studentid = studentid;
        this.libraryid = libraryid;
        this.getbook = getbook;
        this.returnbook = returnbook;
    }
    public String getBookid() {
        return bookid;
    }
    public String getLibraryid() {
        return libraryid;
    }
    public LocalDateTime getgetbook() {
        return getbook;
    }
    public LocalDateTime getreturnbook() {
        return returnbook;
    }
}
class Comment{
    String Studentid;
    String pass;
    String Libraryid;
    String bookid;
    String comment;
    public Comment(String Studentid, String pass, String Libraryid, String bookid, String comment) {
        this.Studentid = Studentid;
        this.pass = pass;
        this.Libraryid = Libraryid;
        this.bookid = bookid;
        this.comment = comment;
    }
}
class Log{
    private String idstudent;
    private String command;
    private String bookid;
    private String libraryid;
    private LocalDateTime time;
    public Log(String idstudent, String command,String bookid,String libraryid ,LocalDateTime time) {
        this.idstudent = idstudent;
        this.command = command;
        this.bookid = bookid;
        this.libraryid = libraryid;
        this.time = time;
    }
    public String getIdstudent() {
        return idstudent;
    }
    public String getCommand() {
        return command;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public String getBookid() {
        return bookid;
    }
    public String getLibraryid() {
        return libraryid;
    }
}
