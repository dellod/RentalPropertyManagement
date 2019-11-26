JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
		ClientController/ApplicationController.java \
		Model/Account.java \
		Model/Address.java \
		Model/Landlord.java \
		Model/Manager.java \
		Model/MyDate.java \
		Model/Name.java \
		Model/Payment.java \
		Model/Person.java \
		Model/Property.java \
		Model/RegisteredRenter.java \
		Model/Renter.java \
		Model/Report.java \
		ServerController/Database.java \
		ServerController/ModelController.java \
		ServerController/Server.java \
		View/Application.java \
		View/LandlordGUI.java \
		View/Manager.java \
		View/ManagerGUI.java \
		View/PropertyRegistration.java \
		View/RegisteredRenter.java \
		View/RegularRenter.java \
		View/RenterGUI.java \
		Main.java \
		
default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class