package ie.just.another.scala.repo.hexagonal.domain.exception

trait PersonExceptions {

  final case class CreatePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull) with PersonExceptions

  final case class FindPersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

  final case class UpdatePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

  final case class DeletePersonException(msg: String, cause: Option[Throwable] = None)
    extends Exception(msg, cause.orNull)

}
