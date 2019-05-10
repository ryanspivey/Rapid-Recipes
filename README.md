# RapidRecipes
A web crawler that pulls data from common recipe sites and curates a grocery list based on provided links.

<h2>*(VERY DIRTY CODE ALERT)*</h2>
<ul>
  <li>I'm really excited about this concept and throwing it together *ASAP!* I'm planning on cleaning everything up and adding
  some missing functionalities after the primary prototype is working. </li>
</ul>

<h2>Libraries/Dependences</h2>
<ul>
  <li>Jsoup 1.11.3</li>
  <li>string-similarity-1.0.0</li>
</ul>



<h2>Tasks</h2>

- [ ] Major Clean Up
- [ ] Use common schema for scraping data from recipe sites (AnyList uses this)
- [ ] Combine amounts of combined ingredients
- [x] Write method to compare all ingredients within BaseRecipes & combine ingredients
- [x] Make unit conversion object for common kitchen measurements.
- [x] Make fraction converter for recipe entries as fractions (i.e. 1/4 cup)
- [x] Web scrape ingredients, units, & amounts using jsoup library
