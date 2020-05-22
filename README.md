#Parking Lot
##About
This is a console based application to simulate a parking lot using a set of commands.
##How to build & run?
###Build
- cd parking_lot.
- run bin/setup
###Run
Application can be via two input modes
- File as an input
  - Run bin/parking_lot ${inputFilePath} 
- Interactive mode
  - Run bin/parking_lot
##Commands
- create_parking_lot
  - example: create_parking_lot 4 
  - Above command will create a parking lot with 4 slots.
- park
  - example: park KA-123 White
  - Above command will park vehicle with color White and registration number KA-123.
- leave
  - example: leave 1
  - Above command is to leave/unpark a cark parked in a given slot. 
- status
  - example: status
  - Above command will print current status of parking lot in a tabular form.
- registration_numbers_for_cars_with_colour
  - example: registration_numbers_for_cars_with_colour white
  - Above command will print registration numbers of all cars with color white.
- slot_numbers_for_cars_with_colour
  - example: slot_numbers_for_cars_with_colour White
  - Above command will output slot numbers for car of a given color.
- slot_number_for_registration_number
  - example: slot_number_for_registration_number KA-123
  - Above command will print slot number for given registration number.
##Example
###File
####Input (contents of file):
create_parking_lot 6  
park KA-01-HH-1234 White  
park KA-01-HH-9999 White    
park KA-01-BB-0001 Black    
park KA-01-HH-7777 Red  
park KA-01-HH-2701 Blue 
park KA-01-HH-3141 Black    
leave 4  
park KA-01-P-333 White  
park DL-12-AA-9999 White    
registration_numbers_for_cars_with_colour White 
slot_numbers_for_cars_with_colour White 
slot_number_for_registration_number KA-01-HH-3141   
slot_number_for_registration_number MH-04-AY-1111
####Output (to STDOUT):
Created a parking lot with 6 slots  
Allocated slot number: 1    
Allocated slot number: 2    
Allocated slot number: 3    
Allocated slot number: 4    
Allocated slot number: 5    
Allocated slot number: 6    
Slot number 4 is free   
Allocated slot number: 4    
Sorry, parking lot is full  
KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333   
1, 2, 4 
6   
Not found  
### Interactive
$ create_parking_lot 6  
Created a parking lot with 6 slots  
$ park KA-01-HH-1234 White  
Allocated slot number: 1    
$ exit
  
  
