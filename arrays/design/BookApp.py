#-> Books in a list
#Active Boolean
#A variable to remember the page number; HashMap to remember each books page number
#CurrentPage variable(getter)

class BookApp:
    
    #BookMap Key(BookName) and Value current Page
    
    def __init__(self):
        self.bookMap = {}
        self.activeBook = ""
        
    def bookAdd(self, newBook):
        self.bookMap[newBook] = 0
    
    def bookRemove(self, book):
        if book in bookMap:
            self.bookMap.pop(book)
        else:
            print("Book not in shelf")
        
    def setCurrentPage(self, book, pageNumber):
        self.bookMap[book] = pageNumber
    
    def getCurrentPage(self, book):
        return self.bookMap[book]
    
    def setActiveBook(self, book, pageNumber):
        self.activeBook = book
        self.setCurrentPage(book, pageNumber)
    
    def getActiveBook(self):
        return self.activeBook
    


app = BookApp()
#app() = bookapp

app.bookAdd("Harry Potter")
app.bookAdd("GOT")
app.bookAdd("Kamasutra")
app.bookAdd("Louda of Aryan")
app.bookAdd("Active Akash")
print(app.bookMap)

app.setActiveBook("GOT", 5)
print(app.getCurrentPage("GOT"))
print(app.getActiveBook())
app.setActiveBook("Harry Potter", 699)
print(app.getActiveBook())
print(app.bookMap)


