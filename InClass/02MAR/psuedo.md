
void main(String[] args)
- BEGIN
  - DECLARE variables
        Fruit (String)
        Quantity (Double)
        PriceForEach (Double)
        Total (Double)
  - CONVERT file
  - SCAN File with Scanner
  - WHILE (file is not empty)
    - Set fruit to line from file
    - SET total to the result of totalprice with quantity and price.
  - ENDWHILE
- END

double totalprice(double quantity, double price)
- BEGIN
    - DELCARE variable
        Total (double)
    - COMPUTE quantity * price and SET it Total
    - RETURN Total
- END