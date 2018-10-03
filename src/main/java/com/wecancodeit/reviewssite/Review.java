package com.wecancodeit.reviewssite;

class Review {
	long id;
	String title = "";
	String imageUrl = "";
	String category = "";
	String content = "";

  public Review(long id, String title, String imageUrl, String category, String content)
  {
	// appropriate :P
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getContent()
	{
		return this.content;
	}
	
	public String getCategory()
	{
	  return this.category;
	}
	
	public String getImageUrl()
	{
	  return this.imageUrl;
	}

//	public int compareTo(Review oFirstCourse) {
//		if(this.getName().compareTo(oFirstCourse.getName()) !=0) {
//			return this.getName().compareTo(oFirstCourse.getName());
//		} else { // Name the same
//			if(this.getDescription().compareTo(oFirstCourse.getDescription())!=0) {
//				return this.getDescription().compareTo(oFirstCourse.getDescription());
//			} else {
//				return 0;
//			}
//		}
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == 0) ? 0 : id));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (this.id == 0) {
			if (other.id != 0)
				return false;
		} else if (id!=other.id)
			return false;
		return true;
	}
}
