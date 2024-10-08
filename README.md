<a id="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/CodecoolGlobal/testing-good-behavior-general-TiborKovari">
    <img src="https://raw.githubusercontent.com/IPHUN1989/bytebattlers/development/frontend/src/assets/wallpaper/Byte_Battlers.png" alt="Byte Battlers Logo" width="auto" height="80">
  </a>

<h3 align="center">Byte Battlers</h3>

  <p align="center">
    This is the repo of the automated test!
    <br />
    <a href="https://github.com/IPHUN1989/bytebattlers" target="_blank"><strong>Explore the SUT »</strong></a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#made-with">Made With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contributors">Contributors</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

[![SUT][SUT-Screenshot]][sut-screenshot]

This project consists of automated tests using Page Factory design pattern, Selenium and BDD approach for a web application which is BoardgameGeek inspired.
Users can search for board games, register themselves securely, add a board game to their virtual collection and rate/review any chosen board game.
> *It is important to note that the **System Under Testing (SUT)** is **not** our work, it was made by a group of other students from Codecool.*

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Made With

This section lists any major technologies used in this project. We also mention certain approaches or design patterns which are important for automated tests.

- **Technologies**
    * [![Java][java]][java-url]
    * [![JUnit][junit]][junit-url]
    * [![Selenium][selenium]][selenium-url]
        *  [![Selenium Webdriver][selenium-webdriver]][selenium-webdriver-url]
    * [![Cucumber][cucumber]][cucumber-url]
- **Design patterns, approaches and others**
    * [![PageFactory][page-factory]][pagefactory-url]
    * [![Bdd][bdd]][bdd-url]
        * [![!Gherkin][gherkin]][gherkin-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

Before you begin, make sure you have the following installed:

1. **Java Development Kit (JDK) 11+**
    - This project is written in Java, so you'll need to have at least JDK 11 installed.
    - [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

2. **Apache Maven**
    - Maven is required for managing the project's dependencies and building the project.
    - [Install Maven](https://maven.apache.org/install.html)

3. **IntelliJ IDEA**
    - We recommend using IntelliJ IDEA as the development environment for this project. You can use either the **Ultimate** or **Community** edition.
    - Make sure to install the following plugins:
        - **Maven** (this should be pre-configured for most Java projects in IntelliJ)
        - **Cucumber for Java** plugin for running BDD tests.
    - [Download IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

4. **Selenium WebDriver**
    - Selenium WebDriver is required to run automated browser tests. Maven will handle the dependency, but ensure you have the correct WebDriver (e.g., ChromeDriver) installed for your browser.
    - [Download WebDriver](https://www.selenium.dev/documentation/webdriver/getting_started/install_drivers/)

5. **Git**
    - Git is needed to clone the repository and manage version control.
    - [Install Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

6. **System Under Testing (SUT)**
    - You will need to set up the System Under Testing (SUT) that this project will test. Instructions for installing and setting up the SUT can be found in its repository:
    - [SUT repository](https://github.com/IPHUN1989/bytebattlers)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


### Installation


1. Clone the repo
   ```sh
   git clone https://github.com/CodecoolGlobal/testing-good-behavior-general-TiborKovari.git
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

You can run every written automated test by starting the `RunAllTests.java` file.

_It is located in the `src/test/java/com/codecool/` folder_

<p align="right">(<a href="#readme-top">back to top</a>)</p>

[![Example][Example-test-result]][example-test-result]

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTORS -->
## Contributors

<a href="https://github.com/CodecoolGlobal/testing-good-behavior-general-TiborKovari/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=CodecoolGlobal/testing-good-behavior-general-TiborKovari" alt="contrib.rocks image" />
</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[sut-screenshot]: src/test/resources/screenshots/homepage.png
[java]: https://img.shields.io/badge/java-%23ED8B00?style=for-the-badge&logoColor=%23ED8B00&labelColor=white&color=%23ED8B00&link=https%3A%2F%2Fwww.java.com%2Fen%2F
[java-url]: https://www.java.com/en/
[junit]: https://img.shields.io/badge/junit_5-%2325A162?style=for-the-badge&logo=junit5&logoColor=%2325A162&labelColor=white&color=%2325A162&link=https%3A%2F%2Fjunit.org%2Fjunit5%2F
[junit-url]: https://junit.org/junit5/
[selenium]: https://img.shields.io/badge/selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=%2343B02A&labelColor=white&color=%2343B02A&link=https%3A%2F%2Fwww.selenium.dev%2F
[selenium-url]: https://www.selenium.dev/
[selenium-webdriver]: https://img.shields.io/badge/selenium_webdriver-43B02A?style=for-the-badge&logo=selenium&logoColor=%23c8102e&labelColor=white&color=%23c8102e&link=https%3A%2F%2Fwww.selenium.dev%2F
[selenium-webdriver-url]: https://www.selenium.dev/documentation/webdriver/
[cucumber]: https://img.shields.io/badge/cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white&labelColor=23D96C&color=23D96C&link=https%3A%2F%2Fcucumber.io%2F
[cucumber-url]: https://cucumber.io/
[page-factory]: https://img.shields.io/badge/Page_Factory-000000?style=for-the-badge&logo=&logoColor=white
[pagefactory-url]: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/PageFactory.html
[bdd]: https://img.shields.io/badge/Behaviour_Driven_Development_(BDD)-000000?style=for-the-badge&logo=&logoColor=white
[bdd-url]: https://cucumber.io/docs/bdd/
[gherkin]: https://img.shields.io/badge/Gherkin-000000?style=for-the-badge&logo=&logoColor=white
[gherkin-url]: https://cucumber.io/docs/gherkin/reference/
[example-test-result]: src/test/resources/screenshots/test_result.png