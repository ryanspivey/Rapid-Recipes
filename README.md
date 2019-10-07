# RapidRecipes
A web crawler that pulls data from common recipe sites and curates a grocery list based on provided links.

<h2>*(VERY DIRTY CODE ALERT)*</h2>
<ul>
  <li>I'm really excited about this concept and throwing it together *ASAP!* I'm planning on cleaning everything up and adding
  some missing functionalities after the primary prototype is working. </li>
  <li> (10/07/2019) Making slow progress. I was stuck on the stacker for a while and decided to take a break.
  1 week turned into 2 and 2 turned into 6 months. I thought I'd try my hand at it using a method I had thought of, but
  wasn't cofident would work properly. Stacker was previously combining all ingredients into a single list which meant
  comparisons had to be made between every item within a single arraylist. I found it easier to group the recipes
  into groups of 2 and compare those ingredients. After the first comparison, group 3 becomes the list that results from a
  comparison of group 1 & 2. Then group 3 is compared with group 2 to create group 4. Group 4 is compared with group 2 to create
  group 5, etc. If you'd like to learn more about how I did this, feel free to contact me. I'd love to talk about more ideas that
  keep advancing this project!</li>
</ul>

<h2>Libraries/Dependences</h2>
<ul>
  <li>Jsoup 1.11.3</li>
  <li>string-similarity-1.0.0</li>
</ul>



<h2>Tasks</h2>

- [ ] Major Clean Up
- [ ] Use common schema for scraping data from recipe sites (AnyList uses this)
- [x] Got basic utility of stacker working (adds amounts of duplicate ingredients & removes duplicates from list) (bane of my existence, algorithms r dum)
- [x] Combine amounts of combined ingredients
- [x] Write method to compare all ingredients within BaseRecipes & combine ingredients based on similarities
- [x] Make unit conversion object for common kitchen measurements.
- [x] Make fraction converter for recipe entries as fractions (i.e. 1/4 cup)
- [x] Web scrape ingredients, units, & amounts using jsoup library
