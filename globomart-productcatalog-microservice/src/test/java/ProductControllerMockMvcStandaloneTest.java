/*
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kumar.productcatalogmicroservice.product.Product;
import com.kumar.productcatalogmicroservice.product.ProductController;
import com.kumar.productcatalogmicroservice.product.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerMockMvcStandaloneTest
{
	private MockMvc mvc;

    @Mock
	private ProductRepository productRepository;

    @InjectMocks
	private ProductController productController;

    // This object will be magically initialized by the initFields method below.
	private JacksonTester<Product> jsonSuperHero;

    @Before
    public void setup() {
        // We would need this line if we would not use MockitoJUnitRunner
        // MockitoAnnotations.initMocks(this);
        // Initializes the JacksonTester
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
		this.mvc = MockMvcBuilders.standaloneSetup(this.productController).setControllerAdvice(null).addFilters(null).build();
    }

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
		given(this.productRepository.findOne(101)).willReturn(new Product(101, "Rob", "Mannon", "RobotMan"));

        // when
		final MockHttpServletResponse response = this.mvc.perform(get("/superheroes/2").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // then
		this.jsonSuperHero.write(new Product(102, "Rob", "Mannon", "RobotMan")).getJson();
    }
}
*/