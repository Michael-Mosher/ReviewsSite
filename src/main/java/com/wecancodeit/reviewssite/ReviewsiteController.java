package com.wecancodeit.reviewssite;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class ReviewsiteController {
	
  @Resource
  ReviewRepository oReviewRepository;
  @RequestMapping("/reviews")
  public String findAllReviews(Model model)
  {
    model.addAttribute("reviews", oReviewRepository.getAllEntries());
	return "reviews";
  }
  
  @RequestMapping("/review")
  public String findAReview(@RequestParam(value="reviewId", required=false, 
	      defaultValue="")String reviewId, Model model)
  {
	  model.addAttribute("review", oReviewRepository.getEntry(new Long(reviewId)));
	  return "review";
  }
}
