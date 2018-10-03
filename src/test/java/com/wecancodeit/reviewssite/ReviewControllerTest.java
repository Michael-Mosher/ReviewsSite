package com.wecancodeit.reviewssite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collection;
import static java.util.Arrays.asList;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@WebMvcTest(ReviewsiteController.class)
public class ReviewControllerTest {
  @Resource
  private MockMvc mvc;
  
  @Mock
  private Review firstReview;
  
  @Mock
  private Review secondReview;
  
  @MockBean
  private ReviewRepository repository;
  
  @Test
  public void shouldBeOkForAllReviews() throws Exception
  {
	mvc.perform(get("/reviews")).andExpect(status().isOk());
  }
  
  @Test
  public void shouldPutAllReviewsIntoModel() throws Exception
  {
	Collection<Review> oReviewCollection = asList(firstReview, secondReview);
	when(repository.getAllEntries()).thenReturn(oReviewCollection);
	mvc.perform(get("/reviews")).andExpect(model().attribute("reviews", is(oReviewCollection)));
  }
  
  @Test
  public void shouldPutCourseIdJavaIntoModel() throws Exception
  {
	mvc.perform(get("/review?reviewId=100")).andExpect(status().isOk());
  }
  
  @Test
  public void shouldRouteToSingleCourseView() throws Exception
  {
	when(repository.getEntry(100)).thenReturn(firstReview);
	mvc.perform(get("/review?reviewId=100")).andExpect(view().name(is("review")));
  }
  
  @Test
  public void shouldPutSingleCourseIntoModel() throws Exception
  {
	when(repository.getEntry(101)).thenReturn(secondReview);
	mvc.perform(get("/review?reviewId=101")).andExpect(model().attribute("review", is(secondReview)));
  }
  
  @Test
  public void shouldNotPutSingleCourseIntoModel() throws Exception
  {
	when(repository.getEntry(500L)).thenReturn(new Review(0,"","","",""));
    mvc.perform(get("/review?reviewId=500")).andExpect(model().attribute("reivew", is(nullValue())));
  }
}
