# ServerDrivenUIDemo

This is the very basic implementation of Server Driven UI usinf RecyclerView.

* Assumptions
1. Shown three different type of UI compoents - Banner, Horizontal list, Grid list
2. Default Images are taken form all three components.
3. Clicking on component shows a Toast with text includes it view type
4. A static UI json is kept inside the code for the sale of simplicity.
5. Sreen Orientation is kept in potrait mode for the sale of simplicity.

* UI Json
{
     "components" : [
         {
             "viewType" : "Banner",
             "text" : "Diwali Sale"
         },
         {
             "viewType" : "list_horizontal",
             "data" : [
                 {
                     "viewType" : "list_item",
                     "text" : "Flat 50% OFF"
                 },
                 {
                     "viewType" : "list_item",
                     "text" : "Flat 70% OFF"
                 }, 
                 {
                     "viewType" : "list_item",
                     "text" : "Flat 80% OFF"
                 },
                 {
                     "viewType" : "list_item",
                     "text" : "Flat 70% OFF"
                 }, 
                 {
                     "viewType" : "list_item",
                     "text" : "Flat 80% OFF"
                 }
             ]
         },
         {
             "viewType" : "Banner",
             "text" : "Deal of the day"
         },
         {
             "viewType" : "list_grid",
             "data" : [
                 {
                     "viewType" : "list_item",
                     "text" : "Under 399"
                 },
                 {
                     "viewType" : "list_item",
                     "text" : "under 499"
                 }, 
                 {
                     "viewType" : "list_item",
                     "text" : "Under 999"
                 },
                 {
                     "viewType" : "list_item",
                     "text" : "Under 1399"
                 }, 
                 {
                     "viewType" : "list_item",
                     "text" : "Under 1999"
                 }
             ]
         }
         
     ]
 }


