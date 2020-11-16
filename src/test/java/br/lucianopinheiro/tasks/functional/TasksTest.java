package br.lucianopinheiro.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		System.setProperty("webdriver.chrome.driver","/home/lpribeiro/eclipse-workspace/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso(){
		WebDriver driver = acessarAplicacao();	
		try {			
			driver.navigate().to("http://localhost:8001/tasks");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//clicar em Add Todo
			driver.findElement(By.id("addTodo")).click();;
			
			//Informar a Descrição
			driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
			
			//Informar a data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		
			//Clicar em Salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de Sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			
			Assert.assertEquals("Sucess!", mensagem);
		} finally {	
			//Fechar o browser
			driver.quit();
		}
		
	}
		@Test
		public void naoDeveSalvarTarefasemDescricao(){
			WebDriver driver = acessarAplicacao();	
			try {			
				driver.navigate().to("http://localhost:8001/tasks");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();;
				
				
				//Informar a data
				driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
				//Clicar em Salvar
				driver.findElement(By.id("saveButton")).click();
				
				//Validar mensagem de Sucesso
				String mensagem = driver.findElement(By.id("message")).getText();
				
				Assert.assertEquals("Fill the task description", mensagem);
			} finally {	
				//Fechar o browser
				driver.quit();
			}

	}
		@Test
		public void naoDeveSalvarTarefaSemData(){
			WebDriver driver = acessarAplicacao();	
			try {			
				driver.navigate().to("http://localhost:8001/tasks");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();;
				
				//Informar a Descrição
				driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				
				
				//Clicar em Salvar
				driver.findElement(By.id("saveButton")).click();
				
				//Validar mensagem de Sucesso
				String mensagem = driver.findElement(By.id("message")).getText();
				
				Assert.assertEquals("Fill the due date", mensagem);
			} finally {	
				//Fechar o browser
				driver.quit();
			}
			
		}
		
		@Test
		public void naoDeveSalvarTarefaComDataPassada(){
			WebDriver driver = acessarAplicacao();	
			try {			
				driver.navigate().to("http://localhost:8001/tasks");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//clicar em Add Todo
				driver.findElement(By.id("addTodo")).click();;
				
				//Informar a Descrição
				driver.findElement(By.id("task")).sendKeys("Teste via Selenium");
				
				//Informar a data
				driver.findElement(By.id("dueDate")).sendKeys("10/10/2001");
			
				//Clicar em Salvar
				driver.findElement(By.id("saveButton")).click();
				
				//Validar mensagem de Sucesso
				String mensagem = driver.findElement(By.id("message")).getText();
				
				Assert.assertEquals("Due date must not be in past", mensagem);
			} finally {	
				//Fechar o browser
				driver.quit();
			}
			
		}
		
}
