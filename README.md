# MobileTV
Приложение, което чете информация от API и я извежда на екрана.
Задачата е да се направи един екран, в който да се покажат основните категории - или като
grid или като list, и при избиране на някоя от тях, да се показва втори екран с
подкатегориите й, които са пак или grid или list. За подкатегориите картинката се взима като се добави https://tvc.mobiletv.bg/sxm/images/subcategory/ пред полето "cover" от
JSON-а. Ако някоя подкатегория има и тя подкатегория, трябва да се добави още едно
ниво - отново grid/list. Максималният брой нива на подкатегориите е 2, та няма нужда от
динамично добавяне, може да се проектира приложението да има 1 или 2 нива.

Изпълнено:
1. Приложението е изработено съгласно заданието и не крашва. 
2. Направени са икони за меню-настройки и икона за стратиране на проложението.
3. Използвани са SharedPreferences с цел съхраняване на настройките (цвят на екрана) между пусканията на приложението.
4. Вградена е настройка за избор на размер на списъка, но на този етап не работи. Това съм го правил, когато е имало такава опция в самия API. 
5. Следващият commit ще включва превод на български език.
6. Със сигурност кода и методите на изготвяне на приложението биха могли да се оптимизират, но на този етап това позволяват възможностите и времето ми. 
