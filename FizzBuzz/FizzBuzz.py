class FizzBuzz:

    def __init__(self, start, end):
        """Initiate conditions where the fizzbuzz will start and end at"""
        self._start = start
        self._end   = end + 1
        
    def verify(self, idx):
        """A verifying method to keep less conditions pre-occupied"""
        if idx % 3 == 0 and idx % 5 == 0:
            return "FizzBuzz"
        elif idx % 3 == 0 and idx % 5 != 0:
            return "Fizz"
        elif idx % 3 != 0 and idx % 5 == 0:
            return "Buzz"
        else:
            return idx
        
    def fizzbuzz(self):
        """Prepare the printing instance of required fizzbuzz conditions"""
        for idx in range(self._start, self._end):
            print(self.verify(idx))
     
if __name__ == "__main__": 
    myObj = FizzBuzz(1, 15)
    myObj.fizzbuzz()