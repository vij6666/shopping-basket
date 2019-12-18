# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I Have implemented a product level discount strategy, concentrating on the Buy M for N discount strategy as this solves
both the buy one get one free and buy three items for the price of two requirements.

The DiscountStrategy interface can be implemented for a basket level discount strategy, this would require relatively 
minor changes to Basket and checkout. This would be appropriate in the case of gift cards or employee discount cards.

