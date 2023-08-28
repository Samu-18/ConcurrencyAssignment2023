JAVAC=/usr/bin/javac
.SUFFIXES: /java .class
SRCDIR=src/clubSimulation
BINDIR=bin/clubSimulation


$(BINDIR)/%.class:$(SRCDIR)/*.java
		$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $^

CLASSES= Clubgoer.class ClubGrid.class ClubView.class CounterDisplay.class GridBlock.class PeopleCounter.class PeopleLocation.class ClubSimulation.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/clubSimulation/*.class


run: $(CLASS_FILES)
	java -cp $(BINDIR) clubSimulation.ClubSimulation